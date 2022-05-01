package at.ac.fhcampus.enums;

public enum Endpoint {
    EVERYTHING("everything"),
    TOP_HEADLINES("top-headlines");

    public final String label;

    Endpoint(String label) {
        this.label = label;
    }
}
