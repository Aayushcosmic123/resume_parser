package com.resume.demo;

import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

public class FileTypeDetector {
    public static String detectFileType(MultipartFile file) throws IOException {
        Tika tika = new Tika();
        return tika.detect(file.getInputStream());
    }
}
