package ma.emsi.linahannouni.tp2;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class Test1 {

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

        //posez une question

        String reponse = model.chat("Comment s'appelle le chat de Pierre ?");
        System.out.println(reponse);


    }


}
