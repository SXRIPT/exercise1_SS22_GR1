package at.ac.fhcampus;

import com.squareup.okhttp.HttpUrl;


import java.net.URL;

public class NewsApi {
    private final String appKey = "aba5826bfd6a41ab980f009db6d19639";

    public URL buildUrl(String endpoint,String query, String country){
        URL url = new HttpUrl.Builder()
                .scheme("https")
                .host("newsapi.org")
                .addPathSegment("v2")
                .addPathSegment(endpoint)
                .addQueryParameter("q",query)
                .addQueryParameter("country",country)
                .addQueryParameter("apiKey",appKey)
                .build().url();
        return url;
    }
}
