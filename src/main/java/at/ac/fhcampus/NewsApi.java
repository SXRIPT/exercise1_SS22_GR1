package at.ac.fhcampus;

import at.ac.fhcampus.enums.*;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;

public class NewsApi {
    private static final String API_KEY = "aba5826bfd6a41ab980f009db6d19639";

    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    private NewsApi() {}

    public static NewsResponse request(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
                String json = Objects.requireNonNull(response.body()).string();
                return gson.fromJson(json, NewsResponse.class);
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host exception");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static HttpUrl.Builder buildBaseUrl(Endpoint endpoint) {
        return new HttpUrl.Builder()
                .scheme("https")
                .host("newsapi.org")
                .addPathSegment("v2")
                .addPathSegment(endpoint.label)
                .addQueryParameter("apiKey", API_KEY);
    }

    public static String buildUrlEverything(String q, Language language, SortBy sortBy) {
        HttpUrl.Builder builder = buildBaseUrl(Endpoint.EVERYTHING);

        if(q != null) builder.addQueryParameter("q", q);
        if(language != null) builder.addQueryParameter("language", language.label);
        if(sortBy != null) builder.addQueryParameter("sortBy", sortBy.label);

        return builder.build().url().toString();
    }

    public static String buildUrlTopHeadlines(String q, Country country, Category category) {
        HttpUrl.Builder builder = buildBaseUrl(Endpoint.TOP_HEADLINES);

        if(q != null) builder.addQueryParameter("q", q);
        if(country != null) builder.addQueryParameter("country", country.label);
        if(category != null) builder.addQueryParameter("category", category.label);

        return builder.build().url().toString();
    }
}
