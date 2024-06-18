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

    // Similarly, add methods to extract name, phone number, etc.
}
