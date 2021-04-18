package com.chnu.texteditor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(length = 100)
    private String title;

    @Column
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "edit_date")
    private LocalDateTime editDate;

    public Document(UUID id, String title, String content, LocalDateTime createDate, LocalDateTime editDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.editDate = editDate;
    }

    public Document(String title, String content, LocalDateTime createDate, LocalDateTime editDate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.editDate = editDate;
    }

    public Document(String content, LocalDateTime createDate, LocalDateTime editDate) {
        this.content = content;
        this.createDate = createDate;
        this.editDate = editDate;
    }

    public Document() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", editDate=" + editDate +
                '}';
    }
}
