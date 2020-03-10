package it.carbon.model;

import java.util.Objects;

public class Piece {

    int abcisse;

    int ordonnee;

    public Piece(int abcisse, int ordonnee) {
        this.abcisse = abcisse;
        this.ordonnee = ordonnee;
    }

    public int getAbcisse() {
        return abcisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return abcisse == piece.abcisse &&
                ordonnee == piece.ordonnee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abcisse, ordonnee);
    }
}
