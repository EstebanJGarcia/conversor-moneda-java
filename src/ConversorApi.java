import com.google.gson.Gson;
import sensibles.API;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApi {
    public DivisasApi tasaDeCambio(String start, String destiny, double valor) {
        //Mi apiKey
        API api = new API();
        String apiKey = api.getAPIkey();
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"+ start + "/"
                + destiny + "/" + valor;
        HttpResponse<String> response;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DivisasApi.class);

        } catch (Exception e) {
            throw new RuntimeException("No tengo contizacion existente a USD");
        }


    }
}
