package gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_expression {
	// Biểu thức chính quy kiểm tra số điện thoại
	public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "0[1-9&&[^26]][0-9]{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
	
	// Biểu thức chính quy cho mật khẩu
	public static boolean validatePassword(String pass) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+-/])[A-Za-z\\d@$!%*?&+-/]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }
	
	public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	public static boolean validateTen(String ten) {
        String regex = "^\\p{Lu}[\\p{L} ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ten);
        return matcher.matches();
    }
	
	public static boolean validateDiaChi(String diaChi) {
		String regex = "[^@#!$%^&*+()]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(diaChi);
		return matcher.matches();
	}
	
	public static boolean validateCCCD(String CCCD) {
		String regex = "\\d{12}|\\d{9}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(CCCD);
		return matcher.matches();
	}
}
