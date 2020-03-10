package it.carbon.model;

import it.carbon.enums.OrientationEnum;

import java.util.Objects;

public class Adventurer extends Piece{
    private final String name;
    private String orientation;
    private String moves;
    private int nbTreasures;

    public Adventurer(int abcisse, int ordonnee, String name, String orientation, String moves) {
        super(abcisse, ordonnee);
        this.name = name;
        this.abcisse = abcisse;
        this.ordonnee = ordonnee;
        this.orientation = orientation;
        this.moves = moves;
    }

    public Adventurer(int abcisse, int ordonnee, String name, String orientation, String moves, int nbTreasures) {
        this(abcisse, ordonnee, name, orientation, moves);
        this.nbTreasures = nbTreasures;
    }

    public int getNbTreasures() {
        return nbTreasures;
    }

    public void setAbcisse(int abcisse) {
        this.abcisse = abcisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public void setNbTreasures(int nbTreasures) {
        this.nbTreasures = nbTreasures;
    }

    public void collectTreasure() {
        setNbTreasures(getNbTreasures() + 1);
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void turnLeft() {
        setOrientation(OrientationEnum.valueOf(orientation).left());
    }

    public void turnRight() {
        setOrientation(OrientationEnum.valueOf(orientation).right());
    }

    public String getName() {
        return name;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public void deleteMoves() {
        setMoves("");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adventurer that = (Adventurer) o;
        return abcisse == that.abcisse &&
                ordonnee == that.ordonnee &&
                nbTreasures == that.nbTreasures &&
                Objects.equals(name, that.name) &&
                Objects.equals(orientation, that.orientation) &&
                Objects.equals(moves, that.moves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abcisse, ordonnee, name, orientation, moves, nbTreasures);
    }

    @Override
    public String toString() {
        return String.format("A - %s - %s - %s - %s - %s", name, abcisse, ordonnee, orientation, nbTreasures);
    }
}
