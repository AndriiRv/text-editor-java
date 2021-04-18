package com.chnu.texteditor.command;

public final class SaveDocumentCommand {
    private final String title;
    private final String content;

    public SaveDocumentCommand(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}