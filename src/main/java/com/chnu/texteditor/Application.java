package com.chnu.texteditor;

import com.chnu.texteditor.service.DocumentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static DocumentService documentService;

    public Application(DocumentService documentService) {
        Application.documentService = documentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}