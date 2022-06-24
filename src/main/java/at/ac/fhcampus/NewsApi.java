package at.ac.fhcampus;

import at.ac.fhcampus.enums.*;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Objects;

public class NewsApi {
    private static final String API_KEY = "aba5826bfd6a41ab980f009db6d19639";
    //private static NewsApi instance = null;

    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    private NewsApi() {}

    /*public static NewsApi getInstance(){              //Würde man hier Singleton anwenden wenn nie eine Instance verwendet wird?
        if(instance == null){
            instance = new NewsApi();
        }
        return instance;
    }*/

    public static NewsResponse request(String url) throws NewsApiException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if(response.code() >= 200 && response.code() <= 299) {
                String json = Objects.requireNonNull(response.body()).string();
                return gson.fromJson(json, NewsResponse.class);
            } else if (response.code() != 404) {
                String json = Objects.requireNonNull(response.body()).string();
                NewsErrorResponse newsErrorResponse = gson.fromJson(json, NewsErrorResponse.class);
                throw new NewsApiException(newsErrorResponse.getMessage());
            } else if(response.code() == 404) {
                throw new NewsApiException("URL not found: " + url);
            }
        } catch (UnknownHostException e) {
            throw new NewsApiException(e);
        } catch (SocketTimeoutException e) {
            throw new NewsApiException(e);
        } catch (IOException e) {
            throw new NewsApiException(e);
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
