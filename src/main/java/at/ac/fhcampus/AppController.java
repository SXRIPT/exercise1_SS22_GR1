package at.ac.fhcampus;

import at.ac.fhcampus.enums.Country;

import java.util.*;

public class AppController {
    private static List<Article> articles;

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return articles;
    }

    public int getArticleCount() {
        return articles == null ? 0 : articles.size();
    }

    public static NewsResponse getAllNewsBitcoin(String query) {
        NewsResponse newsResponse = NewsApi.request(NewsApi.buildUrlEverything(query, null, null));
        articles = newsResponse.getArticles();
        return newsResponse;

    }

    public static NewsResponse getTopHeadlinesAustria(String query) {
        NewsResponse newsResponse = NewsApi.request(NewsApi.buildUrlTopHeadlines(query, Country.AUSTRIA, null));
        articles = newsResponse.getArticles();
        return newsResponse;
    }
    /*public List<Article> getTopHeadlinesAustria() {
        NewsApi newsApi = new NewsApi();
        NewsResponse newsResponse;
        newsResponse = newsApi.getTopHeadlinesAustria("Wien");
        articles = newsResponse.getArticles();
        return articles;
    }

    public List<Article> getAllNewsBitcoin() {
        NewsApi newsApi = new NewsApi();
        NewsResponse newsResponse;
        newsResponse = newsApi.getAllNewsBitcoin("bitcoin");
        articles = newsResponse.getArticles();
        return articles;
    }*/

}
