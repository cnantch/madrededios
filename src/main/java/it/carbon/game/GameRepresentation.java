package it.carbon.game;

import it.carbon.model.Adventurer;
import it.carbon.model.Case;
import it.carbon.model.Mountain;
import it.carbon.model.Treasure;

import java.util.List;
import java.util.stream.Collectors;

public class GameRepresentation {

    protected static final String SPACE_SEPARATOR = " ";

    Game game;

    public GameRepresentation(Game game) {
        this.game = game;
    }

    public String representation() {
        List<String> linesOfCard = game.getCard().getLinesOfCard();
        game.getMountains()
                .forEach(
                        mountain -> placeAPieceInLinesOfCard(new Case(mountain.getAbcisse(), mountain.getOrdonnee()), "M", linesOfCard)
                );
        game.getTreasures().forEach(
                treasure -> placeAPieceInLinesOfCard(new Case(treasure.getAbcisse(), treasure.getOrdonnee()), String.format("T(%s)", treasure.getNbTreasures()), linesOfCard)
        );
        game.getAdventurers().forEach(
                adventurer -> placeAPieceInLinesOfCard(new Case(adventurer.getAbcisse(), adventurer.getOrdonnee()), String.format("A(%s)", adventurer.getName()), linesOfCard)
        );
        return String.join("\n", linesOfCard);
    }

    public String toString() {
        String value = "";
        value = value.concat(game.getCard().toString()).concat("\n");
        final String mountains = game.getMountains().stream().map(
                Mountain::toString
        ).collect(Collectors.joining("\n"));
        value = value.concat(mountains).concat("\n");
        final String treasures = game.getTreasures().stream().map(
                Treasure::toString
        ).collect(Collectors.joining("\n"));
        value = value.concat(treasures).concat("\n");
        final String adventurers = game.getAdventurers().stream().map(
                Adventurer::toString
        ).collect(Collectors.joining("\n"));
        value = value.concat(adventurers).concat("\n");
        return value;
    }

    public void placeAPieceInLinesOfCard(Case aCase, String piece, List<String> linesOfCard) {
        String line = linesOfCard.get(aCase.getOrdonnee());
        String[] pieces = line.split(SPACE_SEPARATOR);
        pieces[aCase.getAbcisse()] = piece;
        linesOfCard.set(aCase.getOrdonnee(), String.join(SPACE_SEPARATOR, pieces));
    }




}
