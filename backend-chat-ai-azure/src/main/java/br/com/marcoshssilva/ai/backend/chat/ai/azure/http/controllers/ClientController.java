package br.com.marcoshssilva.ai.backend.chat.ai.azure.http.controllers;

import br.com.marcoshssilva.ai.backend.chat.ai.azure.http.models.requests.ChatClientRequest;
import br.com.marcoshssilva.ai.backend.chat.ai.azure.http.models.responses.ChatClientResponse;
import br.com.marcoshssilva.ai.backend.chat.ai.azure.http.models.responses.ImageClientResponse;
import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.exceptions.ChatClientInterfaceException;
import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.services.ChatClientInterfaceService;
import org.springframework.ai.image.ImageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/ai")
public class ClientController {
    private final ChatClientInterfaceService chatClientInterfaceService;

    public ClientController(ChatClientInterfaceService chatClientInterfaceService) {
        this.chatClientInterfaceService = chatClientInterfaceService;
    }

    @GetMapping("/prompt")
    public ResponseEntity<ChatClientResponse> callPromptWithSimpleUserInputFromQueryString(@RequestParam(value = "userInput", required = true) String userInput) throws ChatClientInterfaceException {
        ChatClientResponse chatClientResponse = new ChatClientResponse(chatClientInterfaceService.callPrompt(userInput));
        return ResponseEntity.ok(chatClientResponse);
    }

    @PostMapping("/prompt")
    public ResponseEntity<ChatClientResponse> callPromptWithSimpleUserInputFromJson(@RequestBody ChatClientRequest data) throws ChatClientInterfaceException {
        ChatClientResponse chatClientResponse = new ChatClientResponse(chatClientInterfaceService.callPrompt(data.getUserInput()));
        return ResponseEntity.ok(chatClientResponse);
    }

    @GetMapping("/image/generator")
    public ResponseEntity<ImageClientResponse> callImageGeneratorWithSimpleUserInputFromQueryString(@RequestParam(value = "userInput", required = true) String userInput) throws ChatClientInterfaceException {
        ImageResponse imageResponse = chatClientInterfaceService.callImageGenerator(userInput);
        return ResponseEntity.ok(
                new ImageClientResponse(
                        imageResponse.getResult().getOutput().getB64Json(),
                        imageResponse.getResult().getOutput().getUrl(),
                        new Date(
                            System.currentTimeMillis()
                        )
                )
        );
    }

    @PostMapping("/image/generator")
    public ResponseEntity<ImageClientResponse> callImageGeneratorWithSimpleUserInputFromJson(@RequestBody ChatClientRequest data) throws ChatClientInterfaceException {
        ImageResponse imageResponse = chatClientInterfaceService.callImageGenerator(data.getUserInput());
        return ResponseEntity.ok(
                new ImageClientResponse(
                        imageResponse.getResult().getOutput().getB64Json(),
                        imageResponse.getResult().getOutput().getUrl(),
                        new Date(
                            System.currentTimeMillis()
                        )
                )
        );
    }
}
