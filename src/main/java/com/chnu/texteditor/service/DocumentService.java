package com.chnu.texteditor.service;

import com.chnu.texteditor.command.SaveDocumentCommand;
import com.chnu.texteditor.command.UpdateDocumentCommand;
import com.chnu.texteditor.model.Document;

import java.util.List;
import java.util.UUID;

public interface DocumentService {

    void save(SaveDocumentCommand command);

    void update(UpdateDocumentCommand command);

    Document findById(UUID uuid);

    List<Document> findAll();

    void deleteById(UUID uuid);
}