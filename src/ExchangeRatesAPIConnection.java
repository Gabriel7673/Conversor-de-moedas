import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ExchangeRatesConversion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRatesAPIConnection {
    public static String getRate(String address){


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static ExchangeRatesConversion toCoinRate(String json){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        return gson.fromJson(json, ExchangeRatesConversion.class);
    }

    public static String getAddress(String moedaBase, String moedaDesejada){
        return "https://v6.exchangerate-api.com/v6/5d39f4fa20334d740224c994/pair/" + moedaBase
                + "/" + moedaDesejada;
        //return "https://v6.exchangerate-api.com/v6/5d39f4fa20334d740224c994/pair/" + moedaBase
        //        + "/" + moedaDesejada + "/" + valor;
    }

    public static String getAddress(String moedaBase, String moedaDesejada, double valor){
        return "https://v6.exchangerate-api.com/v6/5d39f4fa20334d740224c994/pair/" + moedaBase
                + "/" + moedaDesejada + "/" + valor;
    }
}
