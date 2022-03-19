package at.ac.fhcampus;

public class Menu {
    private AppController controller;
    private static final String INVALID_INPUT_MESSAGE = "";
    private static final String EXIT_MESSAGE = "";

    public void start() {

    }

    private void handleInput(String input) {

    }

    private void getArticleCount(AppController ctrl) {

    }

    private void getTopHeadlinesAustria(AppController ctrl) {

    }

    private void getAllNewsBitcoin(AppController ctrl) {

    }

    private static void printExitMessage() {
        System.out.println("Have a nice day!");

    }

    private static void printInvalidInputMessage() {
        System.out.println("Your input was invalid. Please enter a letter from one of the given choices.");

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
