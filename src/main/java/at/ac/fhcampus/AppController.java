package at.ac.fhcampus;

import java.util.List;

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
        
    }

    public List<Article> generateMockList() {

    }
}
