package at.ac.fhcampus.enums;

public enum SortBy {
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHED_AT("publishedAt");

    public final String label;

    SortBy(String label) {
        this.label = label;
    }
}
