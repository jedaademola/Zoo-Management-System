package edu.mum.mpp.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {


    public static final String APP_NAME = "mpp-project-zoo-system";
    private static final Logger logger = LoggerFactory.getLogger(Utility.class);
    static SecureRandom number = null;
    private static String terminalIdValue;
    private static Integer tranCounter = 0;

    static {
        try {

            number = SecureRandom.getInstance("SHA1PRNG");

        } catch (NoSuchAlgorithmException e) {
            logger.error("generateRandom Exception: " + e.getMessage());
            LoggerUtil.logError(logger, e);
        }
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        // Boolean b = email.matches(EMAIL_REGEX);
        if (email.matches(EMAIL_REGEX))
            return true;
        else
            return false;
    }

    public static String fileContentsToString(String file) {
        String contents = "";

        File f;
        try {
            f = new File(file);

            if (f.exists()) {
                FileReader fr = null;
                try {
                    fr = new FileReader(f);
                    char[] template = new char[(int) f.length()];
                    fr.read(template);
                    contents = new String(template);
                } catch (Exception e) {
                    logger.error("fileContentsToString Exception Inner: " + e.getMessage());
                    LoggerUtil.logError(logger, e);
                } finally {
                    if (fr != null) {
                        fr.close();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("fileContentsToString Exception: " + e.getMessage());
            LoggerUtil.logError(logger, e);
        }
        return contents;
    }


    public static boolean containSpecialCharacter(String unsafeInput) {

        boolean specialCharacterFound = false;

        Pattern p = Pattern.compile("[^A-Za-z0-9-']");
        Matcher m = p.matcher(unsafeInput);
        if (m.find()) {
            specialCharacterFound = true;
        }

        return specialCharacterFound;
    }


    public static Date convertDate(String dateString) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
        //SimpleDateFormat format2 = new SimpleDateFormat("dd MMM yyyy");

        Date date = format1.parse(dateString);

        return date;
    }

    public static boolean validEmail(String email) {
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        // Boolean b = email.matches(EMAIL_REGEX);
        if (email.matches(EMAIL_REGEX))
            return true;
        else
            return false;
    }


    public static boolean isNumeric(String number) {
        boolean isValid = false;

        String expression = "^[-+]?[0-9]*\\.?[0-9]+$";
        CharSequence inputStr = number;
        //Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


    public static String getSaltString() {
        return UUID.randomUUID().toString().substring(0, 5) + UUID.randomUUID().toString().substring(0, 3);
    }


    public static String guidID() {
        return UUID.randomUUID().toString() + UUID.randomUUID().toString();
    }


    public static String getServerURl(HttpServletRequest request, boolean behindProxy, String proxyName) {
        String uri = null;
        try {


            String serverName;

            if (behindProxy) {// If a X-Forwarded-Host-Header is present (e.g. running behind proxy server)


                serverName = proxyName;


            } else { //else no proxy is configured, we can go ahead and pick the servername name from the request


                //append the servername with the port number
                serverName = request.getServerName() +
                        (request.getServerPort() > 0 ? ":" + request.getServerPort() : "");// ":" + "8080";
            }

            uri = request.getScheme() + "://" +   // "http" + "://
                    serverName;
            // + request.getRequestURI() +       // "/people"
            //(request.getQueryString() != null ? "?" +
            //    request.getQueryString() : ""); // "?" + "lastname=Fox&age=30"


        } catch (Exception e) {
            logger.error("getServerURl Exception: " + e.getMessage());
            LoggerUtil.logError(logger, e);
        }
        return uri;
    }


    public static boolean containsNummber(String inputStr) {
        String pattern = "^[a-zA-Z]*$";
        return !inputStr.matches(pattern);


    }

    public static boolean validateName(String name) {
        String pattern = "^[a-zA-Z-']*$";
        return name.matches(pattern);
    }


    public static String stringRemoveRightmost(String str, int len) {

        if (str == null) {
            return null;
        }
        if (len < 0) {
            return "";
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, str.length() - len);
    }


    public static String rightMost(String str, int len) {

        if (str == null) {
            return null;
        }
        if (len < 0) {
            return "";
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }

    public static String leftMost(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return "";
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }


    /* public static Integer generateRandom(int length) {

         if (number != null) {
             return number.nextInt(length);
         }

         throw new RandomGeneratorUnavailableException("10060", "number generator is null or uninitialized");
     }
 */
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return "";
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }

    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return "";
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }


    public static String convertToSha1(String value) {
        String retVal = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");

            md.update(value.getBytes());
            byte[] output = md.digest();

            retVal = bytesToHex(output);

        } catch (Exception e) {
            logger.error("convertToSha1 Exception: " + e.getMessage());
            LoggerUtil.logError(logger, e);
        }
        return retVal;
    }

    public static String convertToSha512(String valueToHash) {

        String retVal = "";

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-512");

            md.update(valueToHash.getBytes());

            byte[] output = md.digest();

            retVal = bytesToHex(output);

        } catch (Exception e) {

            logger.error("convertToSha-512 Exception: " + e.getMessage());

            LoggerUtil.logError(logger, e);

        }

        return retVal;

    }


    public static String bytesToHex(byte[] b) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++) {
            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString().toLowerCase();
    }


    public static String lPad(String str, Integer length, char replace) {

        return String.format("%" + (length - str.length()) + "s", "")
                .replace(" ", String.valueOf(replace))
                +
                str;
    }


    public static boolean hasValidName(String name) {


        String pattern = "^[a-zA-Z-]*$";
        if (name.matches(pattern)) {
            return true;
        }
        return false;

    }


    public static int computeAge(String dateOfBirth) throws Exception {

        final Long MILLI_SECONDS_YEAR = 31558464000L;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

        Date dbDate = dateFormat.parse(dateOfBirth);

        // Compute age.
        long timeDiff = System.currentTimeMillis() - dbDate.getTime();
        int age = (int) (timeDiff / MILLI_SECONDS_YEAR);  //
        return age;
    }

    public static boolean isAlphaNumeric(String s) {
        String pattern = "^[a-zA-Z0-9]*$";
        if (s.matches(pattern)) {
            return true;
        }
        return false;
    }


    public static boolean validateNumber(String unsafePhone) {

        Pattern pattern = Pattern.compile("\\d+"); //accepts only digits
        Matcher matcher = pattern.matcher(unsafePhone);

        boolean valid = false;

        if (matcher.matches()) {
            valid = true;
        }

        return valid;
    }

    public static boolean validateFloat(String unsafePhone) {

        Pattern pattern = Pattern.compile("^[+-]?([0-9]*[.])?[0-9]+"); //accepts only floats
        Matcher matcher = pattern.matcher(unsafePhone);

        boolean valid = false;

        if (matcher.matches()) {
            valid = true;
        }

        return valid;
    }


    public static boolean validatePhoneNumber(String unsafePhone) {

        Pattern pattern = Pattern.compile("\\d+"); //accepts only digits
        Matcher matcher = pattern.matcher(unsafePhone);

        boolean valid = false;

        if (matcher.matches()) {
            valid = true;
        }

        return valid;
    }

    public static boolean containsAlphabet(String unsafeInput) {
        Pattern pattern = Pattern.compile(".*[a-zA-Z].*");
        Matcher matcher = pattern.matcher(unsafeInput);
        boolean valid = false;
        if (matcher.matches()) {
            valid = true;
        }
        return valid;
    }


    public static Double convertToDouble(String value) {
        Double data = 0.0;
        if (value != null && !value.isEmpty() && value.length() > 0) {
            data = Double.parseDouble(value);
        }
        return data;
    }
}
