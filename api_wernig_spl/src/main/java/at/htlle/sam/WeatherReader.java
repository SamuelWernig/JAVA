package at.htlle.sam;

import org.json.JSONObject;

public class WeatherReader {
    public static void main(String[] args) {
        String jsonFromBrowser = """
            {
              "city": "Leoben",
              "temperature": 11,
              "condition": "Sonnig"
            }
        """;
        JSONObject obj = new JSONObject(jsonFromBrowser);
        System.out.println("Stadt: " + obj.getString("city"));
        System.out.println("Temperatur: " + obj.getInt("temperature"));
        System.out.println("Zustand: " + obj.getString("condition"));

    }
}
