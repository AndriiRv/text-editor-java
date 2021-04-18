package com.chnu.texteditor.controller.request;

import java.util.UUID;

public class UpdateDocumentRequest {
    private final UUID uuid;
    private final String content;

    public UpdateDocumentRequest(UUID uuid, String content) {
        this.uuid = uuid;
        this.content = content;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getContent() {
        return content;
    }
}