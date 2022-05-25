package at.ac.fhcampus;

import java.util.Scanner;
import java.util.*;

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
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> printExitMessage();
            default -> printInvalidInputMessage();
        }
        if(!input.equals("q")) start();
    }

    private void getArticleCount(AppController ctrl) {
        System.out.println("Number of articles: " + ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl) {
        List<Article> temp = ctrl.getTopHeadlinesAustria("Wien").getArticles();

        if(temp == null) {
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

        for (Article article : temp) {
            System.out.println(article);
        }
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        List<Article> temp = ctrl.getAllNewsBitcoin("bitcoin").getArticles();

        if(temp == null) {
            System.out.println(NO_RESULTS_MESSAGE);
            return;
        }

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

    private static void printMenu() {
        System.out.println("############################");
        System.out.println("#    Welcome to NewsApp    #");
        System.out.println("############################");
        System.out.println("Please enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: get all news about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}
