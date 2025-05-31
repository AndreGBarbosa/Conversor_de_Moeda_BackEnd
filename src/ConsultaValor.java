import com.google.gson.Gson; // Importe o Gson
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaValor {

    // !!! SUBSTITUA PELA SUA CHAVE DE API !!!
    private static final String API_KEY = "a272b5c2aa37dcfe5bbf8790";

    public ExchangeRateApi consultaValor(String moedaBase) {

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Usa Gson para converter o JSON da resposta para o objeto ExchangeRateApi
                return new Gson().fromJson(response.body(), ExchangeRateApi.class);
            } else {
                System.out.println("Erro na API: Código de status " + response.statusCode());
                System.out.println("Corpo da resposta: " + response.body());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao consultar a API: " + e.getMessage());
            return null; // Retorna null ou lança uma exceção para indicar falha
        }
    }
}