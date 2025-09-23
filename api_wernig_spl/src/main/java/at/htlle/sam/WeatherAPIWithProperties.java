package at.htlle.sam;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class WeatherAPIWithProperties {
    private Properties properties;

    public WeatherAPIWithProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            if (input == null) {
                throw new IOException("Property file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der Konfigurationsdatei: " + e.getMessage());
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args)throws IOException, InterruptedException {
        ConfigLoader config = new ConfigLoader();
        System.out.println("API-Key: " + config.getProperty("API_KEY"));
        String city ="Leoben";
        String apiKey = config.getProperty("API_KEY");
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
