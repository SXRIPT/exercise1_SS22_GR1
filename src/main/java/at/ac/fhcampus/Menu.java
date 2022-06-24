package at.ac.fhcampus;

import java.util.Scanner;
import java.util.*;
import at.ac.fhcampus.AppController;
import at.ac.fhcampus.downloader.Downloader;
import at.ac.fhcampus.downloader.ParallelDownloader;
import at.ac.fhcampus.downloader.SequentialDownloader;

public class Menu {
    private static Menu instance = null;
    private final AppController controller = AppController.getInstance();
    private static final String INVALID_INPUT_MESSAGE = "Your input was invalid. Please enter a letter from one of the given choices.";
    private static final String EXIT_MESSAGE = "Have a nice day!";
    private static final String NO_RESULTS_MESSAGE = "No article was found.";

    private Menu(){}

    public static Menu getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }

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
                case "y" -> getArticleCount(controller);
                case "q" -> printExitMessage();
                default -> handleSpecialInput(input);
            }
        }
        catch(NewsApiException e){
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            start();
        }
        if(!input.equals("q")) start();
    }

    private void handleSpecialInput(String input) {
        if(controller.getArticles() == null) {
            System.out.println("No articles found fetch articles before using!");
            input = "l";
        }

        switch (input) {
            case "e" -> getProviderMostArticles(controller);
            case "f" -> getLongestAuthor(controller);
            case "g" -> getNYTArticles(controller);
            case "h" -> getShortHeadline(controller);
            case "i" -> sortArticles(controller);
            case "j" -> downloadURLs();
            default -> printInvalidInputMessage();
        }

        if(!input.equals("q")) start();
    }


    private void getArticleCount(AppController ctrl) {
        if(checkGetArticles(ctrl)) return;
        System.out.println("Number of articles: " + ctrl.getArticleCount());
    }
    private void getProviderMostArticles(AppController ctrl){
        ctrl.getProviderMostArticles();
    }

    private void getLongestAuthor(AppController ctrl){
        System.out.println(ctrl.getLongestAuthor());
    }
    private void getNYTArticles(AppController ctrl){
        ctrl.getNYTArticles();
    }
    private void getShortHeadline(AppController ctrl){
        ctrl.getShortHeadline().forEach(System.out::println);
    }
    private void sortArticles(AppController ctrl){
        ctrl.sortArticles().forEach(System.out::println);
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

    private void downloadURLs(){
        try {
            int resultSequential = controller.downloadURLs(new SequentialDownloader());
            System.out.println("ANY TIME");
            // TODO print time in ms it took to download URLs sequentially

            // TODO implement the process() function in ParallelDownloader class
            int resultParallel = controller.downloadURLs(new ParallelDownloader());

            // TODO print time in ms it took to download URLs parallel

        } catch (NewsApiException e){
            System.out.println(e.getMessage());
        }
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
        System.exit(0);
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
