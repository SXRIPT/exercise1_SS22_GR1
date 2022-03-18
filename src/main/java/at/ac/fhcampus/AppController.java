package at.ac.fhcampus;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AppController {
    private List<Article> articles;
    private int articleCount;
    // Constructor ?

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return articles;
    }
    public int getArticleCount() {
        return articleCount;
    }

    public List<Article> getTopHeadlinesAustria() {

    }

    public List<Article> getAllNewsBitcoin() {

    }

    protected List<Article> filterList(String query, List<Article> articles) {
        return articles
                .stream()
                .filter(article -> article.getTitle().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)))
                .toList();
    }

    public List<Article> generateMockList() {
        return Arrays.asList(new Article("New York Times", "Bitcoin smth"),
                new Article("Bild", "Österreich"),
                new Article("Günther", "Bitcoin 123"));
    }
}
