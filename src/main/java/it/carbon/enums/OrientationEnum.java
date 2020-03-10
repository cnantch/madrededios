package it.carbon.enums;

public enum OrientationEnum {
    N("N", "W", "E"),
    W("W", "S", "N"),
    E("E", "N", "S"),
    S("S","E","W");

    private final String value;
    private final String left;
    private final String right;


    OrientationEnum(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public String left() {
        return left;
    }

    public String right() {
        return right;
    }
}
