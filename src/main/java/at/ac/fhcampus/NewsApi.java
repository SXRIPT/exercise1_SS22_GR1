package at.ac.fhcampus;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.util.Objects;

public class NewsApi {
    private static final String API_KEY = "aba5826bfd6a41ab980f009db6d19639";
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String TOP_HEADLINE_ENDPOINT = "top-headlines";
    private static final String EVERYTHING_ENDPOINT = "everything";

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    private NewsResponse request(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if(response.body() != null) {
                String json = response.body().string();
                return gson.fromJson(json, NewsResponse.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private NewsResponse getTopHeadlinesAustria(String query) {
        return request(BASE_URL + TOP_HEADLINE_ENDPOINT + "apiKey=" + API_KEY + "&q=" + query);
    }

    private NewsResponse getAllNewsBitcoin(String query) {
        return request(BASE_URL + EVERYTHING_ENDPOINT + "apiKey=" + API_KEY + "&q=" + query);
    }
    /*
    public URL buildUrl(String endpoint,String query, String country){
        URL url = new HttpUrl.Builder()
                .scheme("https")
                .host("newsapi.org")
                .addPathSegment("v2")
                .addPathSegment(endpoint)
                .addQueryParameter("q",query)
                .addQueryParameter("country",country)
                .addQueryParameter("apiKey", API_KEY)
                .build().url();
        return url;
    }

     */
}
