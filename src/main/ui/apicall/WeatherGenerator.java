package ui.apicall;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Weather;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherGenerator {

    private static final String API_KEY = "&APPID=3f964a9af6714f2cc66b43f4a2fa0e2c";
    private String weatherQuery = "https://api.openweathermap.org/data/2.5/weather?q=";
    private String city = "Vancouver";
    private String apiURL = weatherQuery + city + API_KEY;

    private OkHttpClient client = new OkHttpClient();
    private Request request;
    private Response response;
    private String jsonResponse;

    private Weather weather;

    private static WeatherGenerator weatherGenerator;

    private WeatherGenerator() {

    }

    public static WeatherGenerator getInstance() {
        if (weatherGenerator == null) {
            weatherGenerator = new WeatherGenerator();
        }
        return weatherGenerator;
    }

    public Weather retrieveJsonResponse() {
        System.out.println(apiURL);
        setUpRequest();
        try {
            executeCall();
            getJsonResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // CHANGE THIS SHIT LATER
        return weather;
    }

    private void setUpRequest() {
        request = new Request.Builder()
                .url(apiURL)
                .get()
                .build();
    }

    private void executeCall() throws IOException {
        response = client.newCall(request).execute();
    }

    private void getJsonResponse() throws IOException {
        if (response.body() != null) {
            jsonResponse = response.body().string();
            weather = new Weather(getWeatherTemp(), getWeatherId(), getWeatherInfo());
            System.out.println(jsonResponse);
        } else {
            System.out.println("API CALL FAILED :(");
        }
    }

    private String getWeatherTemp() {
        JsonElement jsonElement = new JsonParser().parse(jsonResponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject()
                .getAsJsonObject("main");
        String temp = jsonObject.get("temp").getAsString();
        return temp;
    }

    private String getWeatherInfo() {
        JsonElement jsonElement = new JsonParser().parse(jsonResponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject weatherObject = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject();
        String weatherDetails = weatherObject.get("main").getAsString();
        System.out.println(weatherDetails);
        return weatherDetails;
    }

    private String getWeatherId() {
        JsonElement jsonElement = new JsonParser().parse(jsonResponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject idObject = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject();
        String weatherId = idObject.get("id").getAsString();
        System.out.println(weatherId);
        return weatherId;
    }
}
