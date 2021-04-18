package com.chnu.texteditor.controller.transform;

import com.chnu.texteditor.command.SaveDocumentCommand;
import com.chnu.texteditor.command.UpdateDocumentCommand;
import com.chnu.texteditor.controller.request.SaveDocumentRequest;
import com.chnu.texteditor.controller.request.UpdateDocumentRequest;
import org.springframework.stereotype.Component;

@Component
public class DocumentCommandRequestAssembler {

    public SaveDocumentCommand toCommand(SaveDocumentRequest request) {
        return new SaveDocumentCommand(request.getTitle(), request.getContent());
    }

    public UpdateDocumentCommand toCommand(UpdateDocumentRequest request) {
        return new UpdateDocumentCommand(request.getUuid(), request.getContent());
    }
}