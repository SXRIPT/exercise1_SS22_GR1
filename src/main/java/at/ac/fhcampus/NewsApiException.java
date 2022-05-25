package at.ac.fhcampus;

public class NewsApiException extends Exception {
    public NewsApiException (String error) {
        super(error);
    }
}
