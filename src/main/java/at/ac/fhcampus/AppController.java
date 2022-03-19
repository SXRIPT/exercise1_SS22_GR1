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
        return articles == null ? Collections.emptyList() : articles;
    }

    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin", articles);
    }

    protected List<Article> filterList(String query, List<Article> articles) {
        if(articles == null) return Collections.emptyList();
        return articles
                .stream()
                .filter(article -> article.getTitle().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)))
                .toList();
    }

    private static List<Article> generateMockList() {
        return Arrays.asList(new Article("New York Times", "Bitcoin smth"),
                new Article("Bild", "Österreich"),
                new Article("Günther", "Bitcoin 123"));
    }
}
