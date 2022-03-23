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
        int hash = 7;
        hash = 53 * hash + (title == null ? 0 : title.hashCode());
        hash = 53 * hash + (author == null ? 0 : author.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "Title: " + title +", Author: " + author;
    }
}
