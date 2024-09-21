package br.com.marcoshssilva.ai.backend.chat.ai.azure.http.models.requests;

import java.io.Serial;
import java.io.Serializable;

public class ChatClientRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public ChatClientRequest() { }

    public ChatClientRequest(String userInput) {
        this.userInput = userInput;
    }

    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
