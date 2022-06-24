package at.ac.fhcampus;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Article {
    private String author;
    private final String title;
    private final String description;
    private final String url;
    private final String urlToImage;
    private final String publishedAt;
    private final String content;
    private final Source source;

    /*public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, Source source) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;
    }*/

    public Article(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.description = builder.description;
        this.url = builder.url;
        this.urlToImage = builder.urlToImage;
        this.publishedAt = builder.publishedAt;
        this.content = builder.content;
        this.source = builder.source;
    }

    public static class Builder{
        private final String author;
        private final String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;
        private Source source;

        public Builder(String author, String title){
            this.author = author;
            this.title = title;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder urlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
            return this;
        }

        public Builder publishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder source(Source source) {
            this.source = source;
            return this;
        }



    }

    public int getAuthorLength(){
        int length;
        length = author.length();
        return length;
    }

    public String getAuthor(){
        return author;
    }
    public String getURL(){
        return url;
    }
    public String getUrlToImage(){
        return urlToImage;
    }
    public Source getSource(){
        return source;
    }
    public int getTitleLength(){
        int length;
        length = title.length();
        return length;
    }

    public int getDescriptionLength(){
        int length;
        length = description.length();
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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
        if(author == null){
            this.author = "null";
        }
        /*try {
            save(new URL(this.url));
        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
        }*/
        return

               // System.lineSeparator() + "Source id: " + source.getId() +
                System.lineSeparator() + "Source: " + source.getName() + System.lineSeparator() +
                "Title: " + title + System.lineSeparator() +
                "Author: " + author + System.lineSeparator() +
                "Description: " + description + System.lineSeparator() +
                "Url: " + url + System.lineSeparator() +
                "Image: " + urlToImage + System.lineSeparator() +
                "Date: " + publishedAt + System.lineSeparator() +
                "Content: " + content + System.lineSeparator();
    }

    public void save(URL url) throws IOException, BadLocationException {

        EditorKit kit = new HTMLEditorKit();
        Document doc = kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

        Reader rd = new InputStreamReader(url.openConnection().getInputStream());

        kit.read(rd, doc, 0);

       FileWriter writer = new FileWriter("output.txt");
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        writer.write(doc.getText(0, doc.getLength()) );
        writer.close();

    }
}
