package br.com.marcoshssilva.ai.backend.chat.ai.azure.http.controllers;

import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.exceptions.ChatClientInterfaceException;
import br.com.marcoshssilva.ai.backend.chat.ai.azure.internal.services.ChatClientInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class ClientController {
    private final ChatClientInterfaceService chatClientInterfaceService;

    public ClientController(ChatClientInterfaceService chatClientInterfaceService) {
        this.chatClientInterfaceService = chatClientInterfaceService;
    }

    @GetMapping("/prompt")
    public ResponseEntity<String> callPromptWithSimpleUserInput(@RequestParam(value = "userInput", required = true) String userInput) throws ChatClientInterfaceException {
        return ResponseEntity.ok(chatClientInterfaceService.callPrompt(userInput));
    }
}
