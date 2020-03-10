package it.carbon.game;

import it.carbon.model.Adventurer;
import it.carbon.model.Card;
import it.carbon.model.Mountain;
import it.carbon.model.Treasure;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    Game game = new Game();

    @Test
    void shouldInitializeTheGame() {
        String inputFileName = "src/test/resources/gameFile";

        //When
        game.init(inputFileName);

        //Then
        final GameRepresentation gameRepresentation = game.gameRepresentation();
        assertEquals(". M .\n" +
                ". A(Lara) M\n" +
                ". . .\n" +
                "T(2) T(3) .", gameRepresentation.representation());
        assertEquals(new Card(3,4), game.getCard());
        assertEquals(asList(new Mountain(1,0), new Mountain(2,1)), game.getMountains());
        assertEquals(asList(new Treasure(0,3,2), new Treasure(1,3,3)), game.getTreasures());
        assertEquals(singleton(new Adventurer(1,1, "Lara", "S", "AADADAGGA")), game.getAdventurers());
        assertEquals(9, game.getNbPlays());
    }

    @Test
    void shouldNotInitializeThisGameBecauseOrderOfInstructionsAreInvalid() {
        String inputFileName = "src/test/resources/invalid/gameFileInvalid";

        //When
        assertThrows(IllegalStateException.class, () -> game.init(inputFileName));
    }

    @Test
    public void testPlay() {
        //Given
        final Game game = new Game();
        game.setCard(new Card(3,4));
        final Adventurer adventurer = new Adventurer(1, 1, "Lara", "S", "AADADAGGA");
        game.setAdventurers(singleton(adventurer));
        List<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure(0,3,2));
        treasures.add(new Treasure(1,3,1));
        game.setTreasures(treasures);
        game.setMountains(asList(new Mountain(1,0), new Mountain(2,1)));
        game.setNbPlays(9);

        //When
        game.play();

        //Then
        assertEquals(new Adventurer(0,3,"Lara", "S", "", 3),
                adventurer);
    }

    @Test
    public void testPlayWithTwoAdventurers() {
        //Given
        final Game game = new Game();
        game.setCard(new Card(3,4));
        final Adventurer adventurer = new Adventurer(1, 1, "Lara", "S", "AADADAGGA");
        final Adventurer sndAdventurer = new Adventurer(1, 2, "Fabian", "N", "AAGGDAGAA");
        game.setAdventurers(Set.of(adventurer, sndAdventurer));
        List<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure(0,3,2));
        treasures.add(new Treasure(1,3,1));
        treasures.add(new Treasure(2,3,3));
        game.setTreasures(treasures);
        game.setMountains(asList(new Mountain(1,0), new Mountain(2,1)));
        game.setNbPlays(9);
        //When
        game.play();

        //Then
        System.out.println(new GameRepresentation(game));
        assertEquals(new Adventurer(0,1,"Lara", "S", "", 0),
                adventurer);
        assertEquals(new Adventurer(0,3,"Fabian", "S", "", 1),
                sndAdventurer);
    }

    @Test
    public void testPlayWithTwoAdventurersWithAdditionalMoves() {
        //Given
        final Game game = new Game();
        game.setCard(new Card(3,4));
        final Adventurer adventurer = new Adventurer(1, 1, "Lara", "S", "AADADAGGA");
        final Adventurer sndAdventurer = new Adventurer(1, 2, "Fabian", "N", "AAGGDAGAAGA");
        game.setAdventurers(Set.of(adventurer, sndAdventurer));
        List<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure(0,3,2));
        treasures.add(new Treasure(1,3,1));
        treasures.add(new Treasure(2,3,3));
        game.setTreasures(treasures);
        game.setMountains(asList(new Mountain(1,0), new Mountain(2,1)));
        game.setNbPlays(11);
        //When
        game.play();

        //Then
        System.out.println(new GameRepresentation(game));
        assertEquals(new Adventurer(0,1,"Lara", "S", "", 0),
                adventurer);
        assertEquals(new Adventurer(1,3,"Fabian", "E", "", 2),
                sndAdventurer);
    }

}