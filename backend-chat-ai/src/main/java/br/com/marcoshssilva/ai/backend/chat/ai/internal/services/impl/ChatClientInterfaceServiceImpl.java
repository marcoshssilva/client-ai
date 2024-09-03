package br.com.marcoshssilva.ai.backend.chat.ai.internal.services.impl;

import br.com.marcoshssilva.ai.backend.chat.ai.internal.exceptions.ChatClientInterfaceException;
import br.com.marcoshssilva.ai.backend.chat.ai.internal.services.ChatClientInterfaceService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ChatClientInterfaceServiceImpl implements ChatClientInterfaceService {

    private final ChatClient chatClient;

    public ChatClientInterfaceServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String callPrompt(String userInput) throws ChatClientInterfaceException {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
