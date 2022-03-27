package at.ac.fhcampus;

import java.util.Objects;

public class Article {
    private final String author;
    private final String title;

    public Article(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Article article)) return false;

        return Objects.equals(article.title, this.title) && Objects.equals(article.author, this.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Title: " + title +", Author: " + author;
    }
}
