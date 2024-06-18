package com.resume.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtractor {
    public static String extractEmail(String text) {
        String emailRegex = "([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
    public static String extractPhoneNumber(String text) {
        // Regular expression to match common phone number formats
        String phoneRegex = "(?:(?:\\+|0{0,2})\\d{1,3}[\\s.-]?)?(?:\\(?\\d{3}\\)?[\\s.-]?)?(?:\\d{3}[\\s.-]?\\d{4})";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(0); // Returns the entire matched phone number
        }
        return null;
    }
    // Similarly, add methods to extract name, phone number, etc.
}
