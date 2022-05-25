package at.ac.fhcampus;

public class NewsErrorResponse {
    private String status;
    private String code;
    private String message;

    public NewsErrorResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
