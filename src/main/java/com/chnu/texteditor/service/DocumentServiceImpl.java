package com.chnu.texteditor.service;

import com.chnu.texteditor.command.SaveDocumentCommand;
import com.chnu.texteditor.command.UpdateDocumentCommand;
import com.chnu.texteditor.model.Document;
import com.chnu.texteditor.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImpl.class.getName());

    private final DocumentRepository customerRepository;

    public DocumentServiceImpl(DocumentRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(SaveDocumentCommand command) {
        String title;
        if (command.getTitle() == null || command.getTitle().isBlank()) {
            title = "New document";
        } else {
            title = command.getTitle();
        }

        Document document = new Document(
                UUID.randomUUID(),
                title,
                command.getContent(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        Document saved = customerRepository.save(document);

        LOGGER.info("-- Document '{}' is saved", saved.getTitle());
    }

    @Override
    public void update(UpdateDocumentCommand command) {
        Document document = getEntityDocument(command.getUuid());
        document.setContent(command.getContent());
        document.setEditDate(LocalDateTime.now());

        LOGGER.info("Document {} is updated", document.getTitle());
    }

    @Override
    public Document findById(UUID uuid) {
        Document document = getEntityDocument(uuid);

        LOGGER.info("Found out {}, {} document", document.getTitle(), document.getId());

        return document;
    }

    @Override
    public List<Document> findAll() {
        List<Document> documents = new ArrayList<>();
        customerRepository.findAll().forEach(documents::add);

        LOGGER.info("Output all docs");

        return documents;
    }

    @Override
    public void deleteById(UUID uuid) {
        Document document = getEntityDocument(uuid);
        customerRepository.delete(document);
        LOGGER.info("-- Document '{}' is deleted", document.getTitle());
    }

    public Document getEntityDocument(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document with id " + id + " is not found"));
    }
}