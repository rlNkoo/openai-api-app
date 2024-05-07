package pl.rlnkoo;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

public class ChatGptHelper {
    OpenAiService aiService;

    public ChatGptHelper() {
        aiService = new OpenAiService("sk-proj-fUpVK27t7riC8j6z8HIAT3BlbkFJDiFt0iqwZbxQ5XHdzyxT", Duration.ofSeconds(30));
    }

    public String getBreakfastIdea(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "I have products: " + allProducts + ". What can I make with them for breakfast? Give me 3 ideas";
        return askChatGpt(question);
        }

    public String getDinnerfastIdea(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "I have products: " + allProducts + ". What can I make with them for dinner? Give me 3 ideas";
        return askChatGpt(question);
    }

    public String getHealthyProductsRecomendation(List<String> products) {
        String allProducts = String.join(", ", products);
        String question = "I have products: " + allProducts + ". Which of these products are healthy";
        return askChatGpt(question);
    }

        private String askChatGpt(String question) {
            ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                    .messages(List.of(new ChatMessage("user", question)))
                    .model("gpt-3.5-turbo")
                    .build();
            List<ChatCompletionChoice> choices = aiService.createChatCompletion(completionRequest).getChoices();

            StringBuilder stringBuilder = new StringBuilder();

            choices.stream()
                    .map(ChatCompletionChoice::getMessage)
                    .map(ChatMessage::getContent)
                    .forEach(stringBuilder::append);

            return stringBuilder.toString();
        }
    }
