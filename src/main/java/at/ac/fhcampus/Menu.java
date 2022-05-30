package at.ac.fhcampus;

import java.util.Scanner;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Menu {
    private final AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Your input was invalid. Please enter a letter from one of the given choices.";
    private static final String EXIT_MESSAGE = "Have a nice day!";
    private static final String NO_RESULTS_MESSAGE = "No article was found.";

    public void start() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        handleInput(scanner.nextLine().toLowerCase());
    }

    private void handleInput(String input) {
        try {
            switch (input) {
                case "a" -> getTopHeadlinesAustria(controller);
                case "b" -> getAllNewsBitcoin(controller);
                case "c" -> getIndividualCountry(controller);
                case "d" -> getIndividualQuery(controller);
                case "e" -> getProviderMostArticles(controller);
                case "f" -> getLongestAuthor(controller);
                case "g" -> getNYTArticles(controller);
                case "h" -> getShortHeadline(controller);
                case "i" -> sortArticles(controller);
                case "y" -> getArticleCount(controller);
                case "q" -> printExitMessage();
                default -> printInvalidInputMessage();
            }
        }catch(NewsApiException e){
            System.out.println(e.getMessage());
        }
        if(!input.equals("q")) start();
    }

    private void getArticleCount(AppController ctrl) {
        if(checkGetArticles(ctrl)) return;
        System.out.println("Number of articles: " + ctrl.getArticleCount());
    }
    // welche source hat meiste artikel
    private void getProviderMostArticles(AppController ctrl){
        if(checkGetArticles(ctrl)) return;
        ctrl.getArticles()
                .stream()
                .map(article -> article.getSource().getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

    private void getLongestAuthor(AppController ctrl){
        if(checkGetArticles(ctrl)) return;
        String name = ctrl.getArticles()
                .stream()
                .map(Article::getAuthor)
                .max(Comparator.comparingInt(String::length)).map(Object::toString).orElse("");
        System.out.println(name);
    }
    // wie viele Artikel stammen von source "New York Times"
    private void getNYTArticles(AppController ctrl){
        if(checkGetArticles(ctrl)) return;
        int anzahl = (int) ctrl.getArticles()
                .stream()
                .map(Article::getSource)
                .filter(source -> source.getName().equals("New York Times"))
                .count();
        System.out.println(anzahl);
    }
    // welche artikel haben eine Headline die weniger als 15 Zeichen hat
    private void getShortHeadline(AppController ctrl){
        if(checkGetArticles(ctrl)) return;
        ctrl.getArticles()
                .stream()
                .filter(article -> article.getTitle().length() < 15)
                .forEach(System.out::println);
    }
    // sortiert die Artikel nach der Länge ihrer Beschreibung aufsteigend; bei gleich alphabetisch
    private void sortArticles(AppController ctrl){
        if(checkGetArticles(ctrl)) return;
        ctrl.getArticles()
                .stream()
                .sorted((Comparator.comparingInt(Article::getDescriptionLength).thenComparing(Article::getDescription)))
                .forEach(System.out::println);
    }

    private void getTopHeadlinesAustria(AppController ctrl)throws NewsApiException {
        if(ctrl.getTopHeadlinesAustria("Wien") == null) {
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        List<Article> temp = ctrl.getTopHeadlinesAustria("Wien").getArticles();

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private void getAllNewsBitcoin(AppController ctrl) throws NewsApiException {
        if(ctrl.getAllNewsBitcoin("bitcoin") == null) {
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        List<Article> temp = ctrl.getAllNewsBitcoin("bitcoin").getArticles();

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private void getIndividualCountry(AppController ctrl)throws NewsApiException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Country: ");
        String country = scanner.nextLine().toUpperCase();

        if(ctrl.getIndividualCountry(country) == null){
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        List<Article> temp = ctrl.getIndividualCountry(country).getArticles();

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private void getIndividualQuery(AppController ctrl)throws NewsApiException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Query: ");
        String query = scanner.nextLine();

        if(ctrl.getIndividualQuery(query) == null){
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        List<Article> temp = ctrl.getIndividualQuery(query).getArticles();

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private boolean checkGetArticles(AppController ctrl){
        if (ctrl.getArticles() == null){
            System.out.println("Please select a or b to load Articles first!!");
            return true;
        }
        return false;
    }
    private static void printMenu() {
        System.out.println("############################");
        System.out.println("#    Welcome to NewsApp    #");
        System.out.println("############################");
        System.out.println("Please enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: Get all news about bitcoin");
        System.out.println("c: Get top headlines by Country");
        System.out.println("d: Get headlines by your query");
        System.out.println("e: Get the Provider with the most Articles");
        System.out.println("f: Get the Author with the longest name");
        System.out.println("g: Get the New York Times Articles");
        System.out.println("h: Get short headline Articles");
        System.out.println("i: Sort the articles shortest to longest");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}
