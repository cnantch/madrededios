package it.carbon.model;

public class Mountain extends Piece{

    public Mountain(int abcisse, int ordonnee) {
        super(abcisse, ordonnee);
    }

    @Override
    public String toString() {
        return String.format("M - %s - %s", abcisse, ordonnee);
    }
}
