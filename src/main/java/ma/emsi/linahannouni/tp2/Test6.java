package ma.emsi.linahannouni.tp2;


import dev.langchain4j.agent.tool.Tool;
import ma.emsi.linahannouni.tp2.tools.meteo.MeteoTool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.net.URI;

public class Test6 {


    public static void main(String[] args) {
        MeteoTool tool = new MeteoTool();
        String resultat = tool.donneMeteo("Casablanca");
        System.out.println(resultat);
    }

}
