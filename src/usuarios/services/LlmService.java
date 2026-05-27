package usuarios.services;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

import usuarios.config.ConfigLoader;

public class LlmService {

    private static final String URL = "https://openrouter.ai/api/v1/chat/completions";

    public static String preguntarIA(String prompt) {

        try {

            String apiKey = obtenerApiKey();

            if (apiKey == null || apiKey.isBlank()) {
                return "ERROR IA: falta configurar OPENROUTER_API_KEY";
            }

            String json = """
            {
              "model": "openai/gpt-3.5-turbo",
              "messages": [
                {
                  "role": "user",
                  "content": "%s"
                }
              ]
            }
            """.formatted(prompt.replace("\"", "\\\""));

            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");

            // IMPORTANTE OPENROUTER
            conn.setRequestProperty("HTTP-Referer", "http://localhost");
            conn.setRequestProperty("X-Title", "LevelUp Arcade");

            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            return extraerTexto(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR IA";
        }
    }

   
    private static String obtenerApiKey() {

        String apiKey = System.getenv("OPENROUTER_API_KEY");

        if (apiKey != null && !apiKey.isBlank()) {
            return apiKey;
        }

        apiKey = System.getProperty("openrouter.api.key");

        if (apiKey != null && !apiKey.isBlank()) {
            return apiKey;
        }

        return ConfigLoader.getOpenRouterApiKey();
    }

    private static String extraerTexto(String json) {

        try {
            int index = json.indexOf("\"content\":\"") + 11;
            int end = json.indexOf("\"", index);

            return json.substring(index, end)
                    .replace("\\n", "\n");

        } catch (Exception e) {
            return "No se pudo extraer respuesta";
        }
    }
}
