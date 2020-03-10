package it.carbon.game;

import it.carbon.model.Adventurer;
import it.carbon.model.Mountain;
import it.carbon.model.Treasure;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AdventurerDeplacement {

    public static void move(Adventurer adventurer, Game game, int run) {
        if (adventurer.getMoves().length() > run) {
            switch(adventurer.getMoves().charAt(run)) {
                case 'A' :
                    moveTo(adventurer, game);
                    break;
                case 'G':
                    adventurer.turnLeft();
                    break;
                case 'D':
                    adventurer.turnRight();
                    break;
                default:
                    //Ignore the fake moves
            }
        }
    }

    private static void moveTo(Adventurer adventurer, Game game) {
        int newOrdonnee;
        int newAbcisse;
        int oldAbcisse = adventurer.getAbcisse();
        int oldOrdonnee = adventurer.getOrdonnee();
        List<Mountain> mountains = game.getMountains();
        List<Treasure> treasures = game.getTreasures();
        Set<Adventurer> adventurers = game.getAdventurers();
        switch (adventurer.getOrientation()) {
            case "N":
                newOrdonnee = adventurer.getOrdonnee() - 1;
                moveVerticalUp(adventurer, newOrdonnee, game, mountains, adventurers);
                break;
            case "S":
                newOrdonnee = adventurer.getOrdonnee() + 1;
                moveVerticalDown(adventurer, newOrdonnee, game, mountains, adventurers);
                break;
            case "W":
                newAbcisse = adventurer.getAbcisse() - 1;
                moveHorizontalLeft(adventurer, newAbcisse, game, mountains, adventurers);
                break;
            case "E":
                newAbcisse = adventurer.getAbcisse() + 1;
                moveHorizontalRight(adventurer, newAbcisse, game, mountains, adventurers);
                break;
            default:
                //Nothing to do;
        }
        collectTreasureInAGame(adventurer, game, oldAbcisse, oldOrdonnee, treasures);
    }

    private static void collectTreasureInAGame(Adventurer adventurer, Game game, int oldAbcisse, int oldOrdonnee, List<Treasure> treasures) {
        final Optional<Treasure> treasureOptional = (Optional<Treasure>) game.gotAPiece(adventurer.getAbcisse(), adventurer.getOrdonnee(), treasures);

        treasureOptional.ifPresent(treasure -> {
            if (treasure.hasSome()
                    && (oldAbcisse != adventurer.getAbcisse() || oldOrdonnee != adventurer.getOrdonnee())) {
                adventurer.collectTreasure();
                treasure.removeOne();
            }
            if (!treasure.hasSome()) {
                game.removeTreasure(treasure);
            }
        });
    }

    private static void moveVerticalUp(Adventurer adventurer, int newOrdonnee, Game game, List<Mountain> mountains, Set<Adventurer> adventurers) {
        if (adventurer.getOrdonnee() > 0
                && game.gotAPiece(adventurer.getAbcisse(), newOrdonnee,mountains).isEmpty()
                && game.gotAPiece(adventurer.getAbcisse(), newOrdonnee, adventurers).isEmpty()) {
            adventurer.setOrdonnee(newOrdonnee);
        }
    }

    private static void moveVerticalDown(Adventurer adventurer, int newOrdonnee, Game game, List<Mountain> mountains, Set<Adventurer> adventurers) {
        if (adventurer.getOrdonnee() < game.getCard().getHeight() - 1
                && game.gotAPiece(adventurer.getAbcisse(), newOrdonnee,mountains).isEmpty()
                && game.gotAPiece(adventurer.getAbcisse(), newOrdonnee, adventurers).isEmpty()) {
            adventurer.setOrdonnee(newOrdonnee);
        }
    }
    private static void moveHorizontalLeft(Adventurer adventurer, int newAbcisse, Game game, List<Mountain> mountains, Set<Adventurer> adventurers) {
        if (adventurer.getAbcisse() > 0
                && game.gotAPiece(newAbcisse, adventurer.getOrdonnee(), mountains).isEmpty()
                && game.gotAPiece(newAbcisse, adventurer.getOrdonnee(), adventurers).isEmpty()) {
            adventurer.setAbcisse(newAbcisse);
        }
    }
    private static void moveHorizontalRight(Adventurer adventurer, int newAbcisse, Game game, List<Mountain> mountains, Set<Adventurer> adventurers) {
        if (adventurer.getAbcisse() < game.getCard().getWidth() - 1
                && game.gotAPiece(newAbcisse, adventurer.getOrdonnee(), mountains).isEmpty()
                && game.gotAPiece(newAbcisse, adventurer.getOrdonnee(), adventurers).isEmpty()) {
            adventurer.setAbcisse(newAbcisse);
        }
    }
}
