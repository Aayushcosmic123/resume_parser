package com.resume.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.apache.tika.exception.TikaException;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping("/resume")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, TikaException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        try {
            String fileType = FileTypeDetector.detectFileType(file);
            String extractedText;

            if (fileType.equals("application/pdf") || fileType.equals("application/msword") || fileType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                extractedText = DocumentParser.parseDocument(file.getInputStream());
            } else {
                return ResponseEntity.badRequest().body("Unsupported file type: " + fileType);
            }

            String email = DataExtractor.extractEmail(extractedText);
            String phoneNumber = DataExtractor.extractPhoneNumber(extractedText);

            // You can extract other details like name, address, etc., similarly

            StringBuilder responseBuilder = new StringBuilder();
            responseBuilder.append("Extracted email: ").append(email).append("\n");
            responseBuilder.append("Extracted phone number: ").append(phoneNumber);

            return ResponseEntity.ok(responseBuilder.toString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to process file: " + e.getMessage());
        }
    }
}
