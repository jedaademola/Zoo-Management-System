package edu.mum.mpp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.mum.mpp.util.CustomDateSerializer;
import edu.mum.mpp.util.UserCategory;

import java.time.LocalDateTime;

public class User extends AbstractModel {

    @JsonIgnore
    private long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;
    private String phoneNumber;
    private String address;
    private String ssn;

    private UserCategory userCategory;


    private int active;

    private boolean loginStatus;

    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime lastLogin;

    private Boolean passwordExpired = Boolean.FALSE;

    private int passwordExpirationDaysRemaining;

    private LocalDateTime lockedDate;
    private long loginAttempts;

    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime failedLoginDate;

    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime accountCreatedOn;

    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime passwordChangedOn;

    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime createdOn;

    private long createdBy;
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime lastUpdatedOn;

    private long lastUpdatedBy;


    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public int getPasswordExpirationDaysRemaining() {
        return passwordExpirationDaysRemaining;
    }

    public void setPasswordExpirationDaysRemaining(int passwordExpirationDaysRemaining) {
        this.passwordExpirationDaysRemaining = passwordExpirationDaysRemaining;
    }

    public LocalDateTime getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(LocalDateTime lockedDate) {
        this.lockedDate = lockedDate;
    }

    public long getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(long loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public LocalDateTime getFailedLoginDate() {
        return failedLoginDate;
    }

    public void setFailedLoginDate(LocalDateTime failedLoginDate) {
        this.failedLoginDate = failedLoginDate;
    }

    public LocalDateTime getAccountCreatedOn() {
        return accountCreatedOn;
    }

    public void setAccountCreatedOn(LocalDateTime accountCreatedOn) {
        this.accountCreatedOn = accountCreatedOn;
    }

    public LocalDateTime getPasswordChangedOn() {
        return passwordChangedOn;
    }

    public void setPasswordChangedOn(LocalDateTime passwordChangedOn) {
        this.passwordChangedOn = passwordChangedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }



}
