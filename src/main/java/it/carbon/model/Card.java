package it.carbon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Card {
    private final int width;
    private final int height;

    public Card(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<String> getLinesOfCard() {
        List<String> linesOfcard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            linesOfcard.add(representWidth(width));
        }
        return linesOfcard;
    }

    public String getRepresentation() {
        return String.join("\n", getLinesOfCard());
    }

    private String representWidth(int length) {
        List<String> representationOfWidth = new ArrayList<>();
        for (int i = length; i > 0; i--) {
            representationOfWidth.add(".");
        }
        return String.join(" ", representationOfWidth);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return width == card.width &&
                height == card.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return String.format("C - %s - %s", width, height);
    }
}
