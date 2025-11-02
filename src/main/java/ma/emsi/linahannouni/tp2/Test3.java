package ma.emsi.linahannouni.tp2;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import java.time.Duration;

import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.CosineSimilarity;

public class Test3 {

    public static void main(String[] args) {

        String cle = System.getenv("GEMINI_KEY");

        EmbeddingModel modele = GoogleAiEmbeddingModel
                .builder()
                .apiKey(cle)
                .modelName("gemini-embedding-001")
                .taskType(GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY)
                .outputDimensionality(300)
                .timeout(Duration.ofMillis(2000))
                .logRequests(true)
                .build();

        String phrase1 = "Bonjour, comment allez-vous ?";
        String phrase2 = "Salut, quoi de neuf ?";

        Response<Embedding> reponse1 = modele.embed(phrase1);
        Response<Embedding> reponse2 = modele.embed(phrase2);

        Embedding emb1 = reponse1.content();
        Embedding emb2 = reponse2.content();

        double similarite = CosineSimilarity.between(emb1, emb2);
        System.out.println("Similarité cosinus : " + similarite);
    }
}
