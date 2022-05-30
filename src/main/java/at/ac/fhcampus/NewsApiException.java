package at.ac.fhcampus;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class NewsApiException extends Exception {
    public NewsApiException (String error) {
        super(error);
    }
    public NewsApiException(UnknownHostException e){
        super(e.getMessage());
    }
    public NewsApiException(SocketTimeoutException e){
        super(e.getMessage());
    }
    public NewsApiException(IOException e){
        super(e.getMessage());
        e.printStackTrace();
    }

    public NewsApiException(IllegalArgumentException e){
        super(e.getMessage());
    }
}
