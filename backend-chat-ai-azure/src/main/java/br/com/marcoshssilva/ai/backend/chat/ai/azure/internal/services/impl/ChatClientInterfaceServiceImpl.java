package br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.services.impl;

import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.exceptions.ChatClientInterfaceException;
import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.services.ChatClientInterfaceService;
import org.springframework.ai.azure.openai.AzureOpenAiImageOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ChatClientInterfaceServiceImpl implements ChatClientInterfaceService {

    private final ChatClient chatClient;
    private final ImageModel imageModel;

    public ChatClientInterfaceServiceImpl(ChatClient.Builder chatClientBuilder, ImageModel imageModel) {
        this.chatClient = chatClientBuilder.build();
        this.imageModel = imageModel;
    }

    @Override
    public String callPrompt(String userInput) throws ChatClientInterfaceException {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

    @Override
    public ImageResponse callImageGenerator(String userInput) throws ChatClientInterfaceException {
        return imageModel.call(
            new ImagePrompt(
                userInput,
                AzureOpenAiImageOptions.builder().withN(1).withHeight(1024).withWidth(1024).build()
            )
        );
    }
}
