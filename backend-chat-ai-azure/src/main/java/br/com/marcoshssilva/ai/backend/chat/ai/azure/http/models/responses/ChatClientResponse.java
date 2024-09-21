package br.com.marcoshssilva.ai.backend.chat.ai.azure.http.models.responses;

import java.io.Serial;
import java.io.Serializable;

public class ChatClientResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    public ChatClientResponse() {}

    public ChatClientResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
