package at.ac.fhcampus;

import at.ac.fhcampus.enums.Country;
import at.ac.fhcampus.downloader.Downloader;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public NewsResponse getAllNewsBitcoin(String query) throws NewsApiException{
        NewsResponse newsResponse = null;

        newsResponse = NewsApi.request(NewsApi.buildUrlEverything(query, null, null));

        if(newsResponse != null) {
            setArticles(newsResponse.getArticles());
        }
        return newsResponse;
    }

    public NewsResponse getTopHeadlinesAustria(String query) throws NewsApiException {
        NewsResponse newsResponse = null;

        newsResponse = NewsApi.request(NewsApi.buildUrlTopHeadlines(query, Country.AUSTRIA, null));

        if(newsResponse != null) {
            setArticles(newsResponse.getArticles());
        }
        return newsResponse;
    }

    public NewsResponse getIndividualCountry(String country) throws NewsApiException, IllegalArgumentException{
        NewsResponse newsResponse = null;

        newsResponse = NewsApi.request(NewsApi.buildUrlTopHeadlines(null, Country.valueOf(country), null));

        if(newsResponse != null) {
            setArticles(newsResponse.getArticles());
        }
        return newsResponse;
    }

    public NewsResponse getIndividualQuery(String query) throws NewsApiException{
        NewsResponse newsResponse = null;

        newsResponse = NewsApi.request(NewsApi.buildUrlTopHeadlines(query, null, null));


        if(newsResponse != null) {
            setArticles(newsResponse.getArticles());
        }
        return newsResponse;
    }

    public void getProviderMostArticles(){
            articles
                .stream()
                .map(article -> article.getSource().getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

    public String getLongestAuthor(){
        return articles
                .stream()
                .map(Article::getAuthor)
                .max(Comparator.comparingInt(String::length)).map(Object::toString).orElse("");

    }

    public int getNYTArticles(){
        return (int) articles
                .stream()
                .map(Article::getSource)
                .filter(source -> source.getName().equals("New York Times"))
                .count();
    }

    public List<Article> getShortHeadline(){
        return articles
                .stream()
                .filter(article -> article.getTitle().length() < 15)
                .toList();
    }

    public List<Article> sortArticles(){
        return articles
                .stream()
                .sorted((Comparator.comparingInt(Article::getDescriptionLength).thenComparing(Article::getDescription)))
                .toList();
    }

    public int downloadURLs(Downloader downloader) throws NewsApiException{
        if( articles == null)
            throw new NewsApiException();

        List<String> urls = new ArrayList<>();

        // TODO extract urls from articles with java stream

        return downloader.process(urls);
    }
}
