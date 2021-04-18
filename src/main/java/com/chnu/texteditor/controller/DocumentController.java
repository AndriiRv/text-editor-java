package com.chnu.texteditor.controller;

import com.chnu.texteditor.controller.request.SaveDocumentRequest;
import com.chnu.texteditor.controller.request.UpdateDocumentRequest;
import com.chnu.texteditor.controller.transform.DocumentCommandRequestAssembler;
import com.chnu.texteditor.model.Document;
import com.chnu.texteditor.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;
    private final DocumentCommandRequestAssembler assembler;

    public DocumentController(DocumentService documentService,
                              DocumentCommandRequestAssembler assembler) {
        this.documentService = documentService;
        this.assembler = assembler;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "/all-documents", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Document> findAllDocument() {
        return documentService.findAll();
    }

    @GetMapping(value = "/open", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Document openDocument(String uuid) {
        return documentService.findById(UUID.fromString(uuid));
    }

    @PostMapping
    public ResponseEntity<Object> saveDocument(@RequestBody SaveDocumentRequest request) {
        documentService.save(assembler.toCommand(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateDocument(@RequestBody UpdateDocumentRequest request) {
        documentService.update(assembler.toCommand(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}