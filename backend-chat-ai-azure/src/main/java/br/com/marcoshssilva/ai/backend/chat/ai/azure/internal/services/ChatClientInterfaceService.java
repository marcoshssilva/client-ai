package br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.services;

import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.exceptions.ChatClientInterfaceException;

public interface ChatClientInterfaceService {
    String callPrompt(String userInput) throws ChatClientInterfaceException;
}
