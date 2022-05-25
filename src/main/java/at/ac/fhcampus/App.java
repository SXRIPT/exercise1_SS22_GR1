package at.ac.fhcampus;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}


    // welche source hat meiste artikel
    List<Article> ArticleListNew;
    ArticleListNew = new List<Article>;
Stream<Article> streamFromList = ArticleListNew.stream()
        .map ()

// welche autor längster name
        .max (Comparator.comparingInt(Article.getAuthor()::getLength()))
// wie viele Artikel stammen von source "New York Times"
streamFromList.
// welche artikel haben eine Headline die weniger als 15 Zeichen hat
streamFromList.
// sortiert die Artikel nach der Länge ihrer Beschreibung aufsteigend; bei gleich alphabetisch
streamFromList.


