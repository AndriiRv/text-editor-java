package com.chnu.texteditor.repository;

import com.chnu.texteditor.model.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DocumentRepository extends CrudRepository<Document, UUID> {

}