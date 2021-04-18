package com.chnu.texteditor.command;

import java.util.UUID;

public final class UpdateDocumentCommand {
    private final UUID uuid;
    private final String content;

    public UpdateDocumentCommand(UUID uuid, String content) {
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