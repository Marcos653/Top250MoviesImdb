package org.example;

public enum Attribute {
    TITLE(2),
    IMAGE(5),
    RATING(7),
    YEAR(4);

    private int value;

    Attribute(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
