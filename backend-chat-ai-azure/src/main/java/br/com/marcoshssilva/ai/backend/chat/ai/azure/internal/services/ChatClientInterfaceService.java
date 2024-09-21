package br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.services;

import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.exceptions.ChatClientInterfaceException;
import org.springframework.ai.image.ImageResponse;

public interface ChatClientInterfaceService {
    String callPrompt(String userInput) throws ChatClientInterfaceException;
    ImageResponse callImageGenerator(String userInput) throws ChatClientInterfaceException;
}
