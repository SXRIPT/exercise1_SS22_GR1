package at.ac.fhcampus;

public class Article  {
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
    public String toString() {
        return "Title: " + title +", Author: " + author;
    }
}
