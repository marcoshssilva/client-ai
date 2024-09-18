# Client-AI

A simple Spring Boot application that uses [Spring AI](https://spring.io/projects/spring-ai) to communicate to AI models in [Azure using OpenAI Models](https://azure.microsoft.com/en-us/products/ai-services/openai-service).

My intention is to explore the full potential of generative AI using Spring Boot and various models like Chatgpt, Copilot, llama3, or any others.

## Requirements

- **Only for OpenIA using Azure**: OpenAI endpoint and key in Azure with previously deployment to chat, image and text-to-speech (at least one deployment to each)
- **Only for OpenIA platform**: OpenAI Key with recharged credits to make requests
- JDK Java v21
- Maven v3+

## Install

### Docker Image

You can pull docker image from [marcoshssilvadev/backend-chat-ai-azure](https://hub.docker.com/r/marcoshssilvadev/backend-chat-ai-azure)

Use a simple docker run as:

```bash
docker run --name backend-chat-ai-azure \
  -e OPENAI_APIKEY=$YOUR_KEY_1_OR_2 \
  -e OPENAI_ENDPOINT=$YOUR_API_AZURE_ENDPOINT \
  -e OPENAI_CHAT_DEPLOYMENT=$YOUR_AZURE_AI_DEPLOYMENT_NAME \
  -e OPENAI_CHAT_MODEL=$YOUR_MODEL_NAME \
  -p 8080:8080 \
  marcoshssilvadev/backend-chat-ai-azure
```