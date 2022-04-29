package at.ac.fhcampus;

import java.net.URL;
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
        return filterList("bitcoin", articles);
    }

    protected static List<Article> filterList(String query, List<Article> articles) {
        return articles == null ?
                Collections.emptyList() :
                articles.stream()
                        .filter(article -> article.getTitle().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)))
                        .toList();
    }

 /*   private static List<Article> generateMockList() {
        return Arrays.asList(new Article("New York Times", "Bitcoin smth", description, url, urlToImage, publishedAt, content),
                new Article("Bild", "Österreich", description, url, urlToImage, publishedAt, content),
                new Article("Günther", "Bitcoin 123", description, url, urlToImage, publishedAt, content));
    } */
}
