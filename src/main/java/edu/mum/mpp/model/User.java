package edu.mum.mpp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.mum.mpp.util.CustomDateSerializer;
import edu.mum.mpp.util.UserCategory;

import java.sql.Timestamp;


public class User extends AbstractModel {

    @JsonIgnore
    private long id;

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Timestamp lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Timestamp getFailedLoginDate() {
        return failedLoginDate;
    }

    public void setFailedLoginDate(Timestamp failedLoginDate) {
        this.failedLoginDate = failedLoginDate;
    }

    public Timestamp getAccountCreatedOn() {
        return accountCreatedOn;
    }

    public void setAccountCreatedOn(Timestamp accountCreatedOn) {
        this.accountCreatedOn = accountCreatedOn;
    }

    public Timestamp getPasswordChangedOn() {
        return passwordChangedOn;
    }

    public void setPasswordChangedOn(Timestamp passwordChangedOn) {
        this.passwordChangedOn = passwordChangedOn;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    private String firstName;

    private String lastName;
    private String email;

    private String password;

    private String phoneNumber;
    private String address;
    private String ssn;
    private char gender;


    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private String fullName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private UserCategory category;

    public UserCategory getCategory() {
        return category;
    }

    public void setCategory(UserCategory category) {
        this.category = category;
    }

    private int active;

    private boolean loginStatus;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp lastLogin;

    private Boolean passwordExpired = Boolean.FALSE;

    private int passwordExpirationDaysRemaining;

    private Timestamp lockedDate;
    private long loginAttempts;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp failedLoginDate;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp accountCreatedOn;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp passwordChangedOn;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp createdOn;

    private long createdBy;
    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp lastUpdatedOn;

    private long lastUpdatedBy;


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


    public long getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(long loginAttempts) {
        this.loginAttempts = loginAttempts;
    }


    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }



}
