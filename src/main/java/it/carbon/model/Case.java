package it.carbon.model;

public class Case {
    private final int abcisse;
    private final int ordonnee;

    public Case(int abcisse, int ordonnee) {
        this.abcisse = abcisse;
        this.ordonnee = ordonnee;
    }

    public int getAbcisse() {
        return abcisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }
}
