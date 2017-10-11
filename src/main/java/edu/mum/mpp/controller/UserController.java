package edu.mum.mpp.controller;

import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.exceptions.LockedException;
import edu.mum.mpp.exceptions.UnauthorizedException;
import edu.mum.mpp.model.AccessTokenWithUserDetails;
import edu.mum.mpp.model.LoginRequest;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.model.User;
import edu.mum.mpp.security.AuthenticationWithToken;
import edu.mum.mpp.service.TokenService;
import edu.mum.mpp.service.UserService;
import edu.mum.mpp.util.CustomResponseCode;
import edu.mum.mpp.util.Utility;
import edu.mum.mpp.validation.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/zoo")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ValidateUser validateUser;

    @RequestMapping(value = "/user/authenticate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginRequest loginRequest, HttpServletRequest request) throws Exception {

        validateUser.validateLogin(loginRequest);
        String loginStatus;

        User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {

            if (user.isLoginStatus()) {

                //FIRST TIME LOGIN
                if (user.getPasswordChangedOn() == null || user.getPasswordExpired()
                        || CustomResponseCode.INACTIVE_USER == user.getActive()) {

                    Response resp = new Response();

                    resp.setCode(CustomResponseCode.CHANGE_P_REQUIRED);
                    resp.setDescription("Change password Required");
                    return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);//202
                }

                if (CustomResponseCode.DEACTIVE_USER == user.getActive()) {

                    Response resp = new Response();

                    resp.setCode(CustomResponseCode.FAILED);
                    resp.setDescription("User Account Deactivated, please contact Administrator");
                    return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                int loginAttemptsConfig = 5;

                if (user.getLoginAttempts() >= loginAttemptsConfig || user.getLockedDate() != null) {
                    // lock account after x failed attempts or locked date is not null
                    userService.lockLogin(user.getId());
                    throw new LockedException(CustomResponseCode.LOCKED_EXCEPTION, "Your account has been locked, kindly contact System Administrator");
                }


            } else {
                //update login failed count and failed login date
                loginStatus = "failed";
                //  emailSmsUtil.SendEmail("", user.getEmail(), "Coronation Bank Merchant Online Banking Account Login Alert",
                //     CustomResponseCode.LOGIN, "", user.getId(), user.getFirstName() + " " + user.getLastName(), "", loginStatus);

                userService.updateFailedLogin(loginRequest.getUsername());
                throw new UnauthorizedException(CustomResponseCode.UNAUTHORIZED, "Invalid Login details.");
            }

        } else if (user == null) {
            //NO NEED TO update login failed count and failed login date SINCE IT DOES NOT EXIST
            throw new UnauthorizedException(CustomResponseCode.UNAUTHORIZED, "Login details does not exist");
        }


        AuthenticationWithToken authWithToken = new AuthenticationWithToken(user, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_RETAIL_USER,ROLE_SUPER_ADMIN"));

        String newToken = this.tokenService.generateNewToken();
        authWithToken.setToken(newToken);
        tokenService.store(newToken, authWithToken);
        SecurityContextHolder.getContext().setAuthentication(authWithToken);

        userService.updateLogin(loginRequest.getUsername(), true);

        AccessTokenWithUserDetails details = new AccessTokenWithUserDetails(newToken, user);

        loginStatus = " successful";
        // emailSmsUtil.SendEmail("", user.getEmail(), "Coronation Bank Merchant Online Banking Account Login Alert",
        //     CustomResponseCode.LOGIN, "", user.getId(), user.getFirstName() + " " + user.getLastName(), "", loginStatus);

        return new ResponseEntity<>(details, HttpStatus.OK);

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody @Validated User user, HttpServletRequest request) throws Exception {

        validateUser.validationCreateUser(user);

        HttpStatus httpCode = HttpStatus.INTERNAL_SERVER_ERROR;

        Response resp = new Response();

        User userExist = userService.isUserExists(user.getEmail(), user.getPhoneNumber());

        User userCurrent = TokenService.getCurrentUserFromSecurityContext();


        if (userExist != null) {

            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION, " User account already exist");
        } else {
            String password = Utility.getSaltString();
            //user.setPassword(passwordEncoder.encode(Utility.convertToSha1(password)));

            user.setPassword(passwordEncoder.encode(password));
            user.setCreatedBy(userCurrent.getId());

            User response = userService.create(user);

            if (response != null) {
                if (response.getId() > 0) {

                    resp.setCode(CustomResponseCode.SUCCESS);
                    resp.setDescription("Successful");
                    httpCode = HttpStatus.OK;

                    //SEND MAIL HERE  TODO
                    // emailSmsUtil.SendEmail("", user.getEmail(), "Coronation Bank Merchant Online Banking Account Creation",
                    //      CustomResponseCode.CREATE_USER, password, user.getId(), user.getFirstName() + " " + user.getLastName(), "", "");

                }
            } else {

                resp.setCode(CustomResponseCode.FAILED);
                resp.setDescription("Not successful");
                httpCode = HttpStatus.INTERNAL_SERVER_ERROR;
            }


        }

        return new ResponseEntity<>(resp, httpCode);
    }
}
