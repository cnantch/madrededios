package it.carbon.model;

import java.util.Objects;

public class Treasure extends Piece{
    private int nbTreasures;

    public Treasure(int abcisse, int ordonnee, int nbTreasures) {
        super(abcisse, ordonnee);
        this.nbTreasures = nbTreasures;
    }


    public int getNbTreasures() {
        return nbTreasures;
    }

    public void setNbTreasures(int nbTreasures) {
        this.nbTreasures = nbTreasures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return abcisse == treasure.abcisse &&
                ordonnee == treasure.ordonnee &&
                nbTreasures == treasure.nbTreasures;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abcisse, ordonnee, nbTreasures);
    }

    public void removeOne() {
        setNbTreasures(nbTreasures - 1);
    }

    public boolean hasSome() {
        return nbTreasures > 0;
    }

    @Override
    public String toString() {
        return String.format("T - %s - %s - %s", abcisse, ordonnee, nbTreasures);
    }
}
