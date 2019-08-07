package singleton;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator {

    private OkHttpClient client = new OkHttpClient();

    private Request request;

    private Response response;

    private String jsonReponse;

    private static QuoteGenerator quoteGenerator;

    private QuoteGenerator() {

    }

    public static QuoteGenerator getInstance() {
        if (quoteGenerator == null) {
            quoteGenerator = new QuoteGenerator();
        }
        return quoteGenerator;
    }

    public List<String> getQuoteJson() {
        setUpRequest();
        List<String> quoteAuthorList = new ArrayList<>();
        try {
            executeCall();
            getJsonReponse();
            String quoteString = getQuoteString();
            String authorString = getAuthorString();
            quoteAuthorList.add(quoteString);
            quoteAuthorList.add(authorString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quoteAuthorList;
    }

    private void setUpRequest() {
        request = new Request.Builder()
                .url("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en")
                .get()
                .build();
//                .url("https://andruxnet-random-famous-quotes.p.rapidapi.com/?cat=famous&count=10")
//                .get()
//                .addHeader("x-rapidapi-host", "andruxnet-random-famous-quotes.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "b3d87f60edmsh16ffc106f92745fp14f1c1jsn28f6597f21d6")
//                .build();
    }

    private void executeCall() throws IOException {
        response = client.newCall(request).execute();
    }

    private void getJsonReponse() throws IOException {
        if (response.body() != null) {
            jsonReponse = response.body().string();
        } else {
            System.out.println("YO API CALL FAILED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    private String getQuoteString() {
        JsonElement jsonElement = new JsonParser().parse(jsonReponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String quoteString = jsonObject.get("quoteText").getAsString();
        return quoteString;
    }

    private String getAuthorString() {
        JsonElement jsonElement = new JsonParser().parse(jsonReponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String authorString = jsonObject.get("quoteAuthor").getAsString();
        return authorString;
    }
}
