package edu.mum.mpp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.mum.mpp.util.CustomDateSerializer;
import edu.mum.mpp.util.UserCategory;

import java.io.Serializable;
import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessTokenWithUserDetails implements Serializable {

    @JsonProperty("accessToken")
    private String accessToken;


    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;


    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("lastLogin")
    private LocalDateTime lastLogin;


    @JsonProperty("passwordExpirationDaysRemaining")
    private int passwordExpirationDaysRemaining;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("failedLoginDate")
    private LocalDateTime failedLoginDate;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("passwordChangedOn")
    private LocalDateTime passwordChangedOn;


    @JsonProperty("userCategory")
    private UserCategory category;


    public AccessTokenWithUserDetails(String token, User user) {
        this.accessToken = token;

        this.email = user.getEmail();
        this.category = user.getUserCategory();

        this.phoneNumber = user.getPhoneNumber();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.failedLoginDate = user.getFailedLoginDate();
        this.lastLogin = user.getLastLogin();
        this.passwordChangedOn = user.getPasswordChangedOn();
        this.passwordExpirationDaysRemaining = user.getPasswordExpirationDaysRemaining();


    }

}
