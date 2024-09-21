# Client-AI

A simple Spring Boot application that uses [Spring AI](https://spring.io/projects/spring-ai) to communicate to AI models in [Azure using OpenAI Models](https://azure.microsoft.com/en-us/products/ai-services/openai-service).

My intention is to explore the full potential of generative AI using Spring Boot and various models like Chatgpt, Copilot, llama3, or any others.

## Requirements

- **Only for OpenIA using Azure**: <br/>OpenAI endpoint and key in Azure with previously deployment to chat, image and text-to-speech (at least one deployment to each)
- **Only for OpenIA platform**: <br/>OpenAI Key with recharged credits to make requests
- JDK Java v21
- Maven v3+

## Install

### Docker Image

You can pull docker image from [marcoshssilvadev/backend-chat-ai-azure](https://hub.docker.com/r/marcoshssilvadev/backend-chat-ai-azure)

Use a simple docker run as:

```bash
docker run --name backend-chat-ai-azure \
  -e OPENAI_APIKEY="your_actual_key_here" \
  -e OPENAI_ENDPOINT="https://your-api-endpoint.azurewebsites.net" \
  -e OPENAI_CHAT_DEPLOYMENT="your_chat_deployment_name" \
  -e OPENAI_CHAT_MODEL="your_chat_model_name" \
  -e OPENAI_IMAGE_DEPLOYMENT="your_image_deployment_name"
  -e OPENAI_IMAGE_MODEL="your_image_model_name" \
  -p 8080:8080 \
  -p 9000:9000 \
  marcoshssilvadev/backend-chat-ai-azure:latest
```

## API Endpoints

### 1. Using Chat prompt

```curl
GET http://localhost:8080/api/ai/v1/chat/prompt?userInput={{$random.alphanumeric(8)}}
```
or
```curl
POST http://localhost:8080/api/ai/v1/chat/prompt
Content-Type: application/json

{
  "userInput": ""
}
```

### 2. Using Image generator

```curl
GET http://localhost:8080/api/ai/v1/image/generator?userInput={{$random.alphanumeric(8)}}
```
or
```curl
POST http://localhost:8080/api/ai/v1/image/generator
Content-Type: application/json

{
  "userInput": ""
}
```