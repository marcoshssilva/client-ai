package br.com.marcoshssilva.ai.backend.chat.ai.internal.services;

import br.com.marcoshssilva.ai.backend.chat.ai.internal.exceptions.ChatClientInterfaceException;

public interface ChatClientInterfaceService {
    String callPrompt(String userInput) throws ChatClientInterfaceException;
}
