package at.ac.fhcampus.enums;

public enum Language {
    ARABIC("ar"),
    GERMAN("de"),
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    HEBREW("he"),
    ITALIAN("it"),
    DUTCH("nl"),
    NORWEGIAN("no"),
    PORTUGUESE("pt"),
    RUSSIAN("ru"),
    SWEDISH("sv"),
    URDU("ud"),
    CHINESE("zh");

    public final String label;

    Language(String label) {
        this.label = label;
    }
}
