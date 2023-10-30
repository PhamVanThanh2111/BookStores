package gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_expression {
	public static boolean validatePhoneNumber(String phoneNumber) {
        // Biểu thức chính quy kiểm tra số điện thoại
        String regex = "0[1-9&&[^26]][0-9]{8}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
