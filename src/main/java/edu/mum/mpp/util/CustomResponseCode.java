package edu.mum.mpp.util;


public class CustomResponseCode {


    public static final String FAILED = "101";

    public static final String INVALID_REQUEST = "01";
    public static final String SUCCESS_200 = "200";

    public static final String SUCCESS_00 = "00";
    public static final String SUCCESS_90000 = "90000";


    public static final String CONFLICT_EXCEPTION = "07";
    public static final String LOCKED_EXCEPTION = "423";

    public static final String NOT_FOUND_EXCEPTION = "04";
    public static final String SUCCESS = "00";

    public static final int ACTIVE_USER = 1;
    public static final int INACTIVE_USER = 0;
    public static final int DEACTIVE_USER = 2;

    public static final String CHANGE_P_REQUIRED = "15";

    public static final String UNAUTHORIZED = "02";
    public static final String OTHERS = "05";


    public static final String USER_CATEGORY_BANK_ADMIN = "B";
    public static final String USER_CATEGORY_RETAIL_USER = "R";
    public static final String USER_CATEGORY_COORPORATE = "C";
    public static final String USER_CATEGORY_ISW_USER = "I";

    public static final String FORGET_PASSWORD = "F";
    public static final String LOGIN = "L";
    public static final String CREATE_USER = "C";

    public static final String INTERTRANSFER = "intertransfer";
    public static final String INTRATRANSFER = "intratransfer";
    public static final String SELFTRANSFER = "selftransfer";
    public static final String FAILED_ESB = "FAILED FROM ESB";

    public static final String BILLPAYMENT = "BILLPAYMENT";
    public static final String RECHARGE = "RECHARGE";


    public static final String TRANSFER_SUCCESS = "TRANSFER SUCCESS";
    public static final String TRANSFER_FAILED = "TRANSFER FAILED";

    /*.............................ESB APIs*/
    public static final String NAME_ENQUIRY = "NAME_ENQUIRY";
    public static final String USER_ACCOUNT = "USER_ACCOUNT";
    public static final String TRANSACTION_SUMMARY = "TRANSACTION_SUMMARY";
    public static final String TRANSFER_URL = "TRANSFER_URL";

    public static final String BILLER_CATEGORIES = "BILLER_CATEGORIES";
    public static final String BILLER_ITEMS = "BILLER_ITEMS";
    public static final String BILLER_PAYMENT = "BILLER_PAYMENT";
    public static final String SUSPENSE_ACCOUNT = "SUSPENSE_ACCOUNT";


    public static final String CHANNEL = "2";

    public static final String PERIODS = "PERIODS";
    public static final String EVENTS = "EVENTS";
    public static final String CHANNELS = "CHANNELS";

    public static final String LIMIT_TYPE = "LIMIT_TYPE";

    public static final String PERIODS_DAILY = "Daily";
    public static final String PERIODS_WEEKLY = "Weekly";
    public static final String PERIODS_MONTHLY = "Monthly";

    public static final String LIMIT_TYPE_CUMULATIVE = "CUMULATIVE";
    public static final String LIMIT_TYPE_SINGLE = "SINGLE";


    public static final String EMAIL_URL = "EMAIL_URL";
    public static final String SMS_URL = "SMS_URL";

    /*.............................*/

    public static final String CHARGE_FEE = "CHARGE_FEE";
    public static final String LOGIN_ATTEMPTS_CONFIG = "LOGIN_ATTEMPTS_CONFIG";


}
