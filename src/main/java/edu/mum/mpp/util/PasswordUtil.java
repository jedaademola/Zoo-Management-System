package edu.mum.mpp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lukman.Arogundade on 11/1/2016.
 */
public class PasswordUtil {

    /*
    PASSWORD

  (			# Start of group
  (?=.*\d)		#   must contains one digit from 0-9
  (?=.*[a-z])		#   must contains one lowercase characters
  (?=.*[A-Z])		#   must contains one uppercase characters
  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
              .		#     match anything with previous condition checking
                {8,20}	#        length at least 8 characters and maximum of 20
   )			# End of group



   USERNAME

   ^                    # Start of the line
  [a-z0-9_-]	     # Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
             {6,15}  # Length at least 6 characters and maximum length of 15
$                    # End of the line

     */

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    private static final String USERNAME_PATTERN = "^[A-Za-z0-9_-]{6,15}$";
    //Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean passwordValidator(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);

        matcher = pattern.matcher(password);
        return matcher.matches();
    }


    public static boolean userNameValidator(String username) {
        pattern = Pattern.compile(USERNAME_PATTERN);

        matcher = pattern.matcher(username);
        return matcher.matches();
    }


}
