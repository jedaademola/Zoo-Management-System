package edu.mum.mpp.validation;


import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.model.LoginRequest;
import edu.mum.mpp.model.User;
import edu.mum.mpp.service.UserService;
import edu.mum.mpp.util.CustomResponseCode;
import edu.mum.mpp.util.PasswordUtil;
import edu.mum.mpp.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidateUser {

    @Autowired
    private UserService userService;

    public void validatePassword(String username, String password, String oldPassword) {
        if (username == null || username.isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Username cannot be empty");

        if (password == null || password.isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Password cannot be empty");


        if (oldPassword == null || oldPassword.isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Old Password cannot be empty");

        if (!PasswordUtil.passwordValidator(password))
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Password Format");
    }

    public void validateLogin(LoginRequest loginRequest) {

        if (loginRequest.getUsername() == null || loginRequest.getUsername().isEmpty()) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Username");
        }


        if (loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Password ");
        }
    }

    public void validationCreateUser(User user) {


        if (user.getEmail() == null || user.getEmail().isEmpty()) {

            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Email ");
        }
        if (!Utility.validEmail(user.getEmail()))
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Email Address");


        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid FirstName ");
        }

        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Last Names ");
        }

        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()
                ) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Phone Number ");
        }
        if (!Utility.isNumeric(user.getPhoneNumber()))
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Mobile Number format");

        if (user.getPhoneNumber().length() < 11 || user.getPhoneNumber().length() > 14)//PHONE NUMBER LENGTH********** TODO
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Mobile Number Length");


        if (user.getUserCategory() != null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Category");

        }
    }
}