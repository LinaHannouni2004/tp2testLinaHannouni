package ma.emsi.linahannouni.tp2;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.input.Prompt;


import java.util.Map;


public class Test2 {

    public static void main(String[] args) {


        String cle = System.getenv("GEMINI_KEY");

        //Création du Modèle

        ChatModel model = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .logRequests(true)
                .build();







        PromptTemplate template = PromptTemplate.from("Traduis le texte suivant en anglais : {{texte}}");


        String phrase = "Bonjour tout le monde, je m'appelle Lina et j'étudie à l'EMSI.";


        Prompt prompt=template.apply(Map.of("texte", phrase));

        String reponse= model.chat(prompt.text());
        System.out.println(reponse);
    }
}
