package at.ac.fhcampus;

import at.ac.fhcampus.enums.Country;

import java.util.*;

public class AppController {
    private List<Article> articles;

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return articles;
    }

    public int getArticleCount() {
        return articles == null ? 0 : articles.size();
    }

    public NewsResponse getAllNewsBitcoin(String query) {
        NewsResponse newsResponse = NewsApi.request(NewsApi.buildUrlEverything(query, null, null));
        if(newsResponse != null) {
            setArticles(newsResponse.getArticles());
        }
        return newsResponse;
    }

    public NewsResponse getTopHeadlinesAustria(String query) {
        NewsResponse newsResponse = NewsApi.request(NewsApi.buildUrlTopHeadlines(query, Country.AUSTRIA, null));
        if(newsResponse != null) {
            setArticles(newsResponse.getArticles());
        }
        return newsResponse;
    }
}
