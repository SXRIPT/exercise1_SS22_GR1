package at.ac.fhcampus;

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

    public List<Article> getTopHeadlinesAustria() {
        NewsApi newsApi = new NewsApi();
        NewsResponse newsResponse;
        newsResponse = newsApi.getTopHeadlinesAustria("corona");
        articles = newsResponse.getArticles();
        return articles;
    }

    public List<Article> getAllNewsBitcoin() {
        NewsApi newsApi = new NewsApi();
        NewsResponse newsResponse;
        newsResponse = newsApi.getAllNewsBitcoin("bitcoin");
        articles = newsResponse.getArticles();
        return articles;

    }
}
