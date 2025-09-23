package at.htlle.sam;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class WeatherApiClientOnline {
    public static void main(String[] args)throws IOException, InterruptedException {
        String city ="Leoben";
        String apiKey = "604084579bfaba57655dc463df7e2102";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric&lang=de";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body());
        String name =  jsonObject.getString("name");
        double temp =  jsonObject.getJSONObject("main").getDouble("temp");
        double humidity =  jsonObject.getJSONObject("main").getDouble("humidity");
        String description =  jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        String sky = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

        System.out.println("Ort: " + name);
        System.out.println("Temperatur: " + temp + " °C");
        System.out.println("Humidity: " + humidity);
        System.out.println("Beschreibung: " + description);
        System.out.println("Sky: " + sky);
    }
}
