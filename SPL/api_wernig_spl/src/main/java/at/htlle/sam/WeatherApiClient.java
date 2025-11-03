package at.htlle.sam;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class WeatherApiClient {
    public static void main(String[] args) throws Exception {
        String apiKey = "604084579bfaba57655dc463df7e2102";
        String city = "Leoben";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric&lang=de";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject obj = new JSONObject(response.body());
        String name = obj.getString("name");
        double temp = obj.getJSONObject("main").getDouble("temp");
        String description = obj.getJSONArray("weather").getJSONObject(0).getString("description");

        System.out.println("Ort: " + name);
        System.out.println("Temperatur: " + temp + " °C");
        System.out.println("Beschreibung: " + description);
    }
}
