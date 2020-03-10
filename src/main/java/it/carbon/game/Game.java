package it.carbon.game;

import it.carbon.command.*;
import it.carbon.model.*;
import it.carbon.reader.CardFileReader;
import it.carbon.splitter.InstructionSplitter;

import java.util.*;
import java.util.stream.Stream;

public class Game {

    private Card card;
    private List<Mountain> mountains = new ArrayList<>();
    private List<Treasure> treasures = new ArrayList<>();
    private Set<Adventurer> adventurers = new HashSet<>();

    private CardFileReader cardFileReader = new CardFileReader();
    private InstructionSplitter instructionSplitter = new InstructionSplitter();

    private final Map<String, InstructionCommand> instructionCommandMap;

    private int nbPlays;

    public Game() {
        instructionCommandMap = new HashMap<>();
        instructionCommandMap.put("C", new CardInstructionCommand());
        instructionCommandMap.put("T", new TreasureInstructionCommand());
        instructionCommandMap.put("M", new MountainInstructionCommand());
        instructionCommandMap.put("A", new AdventurerInstructionCommand());
    }

    public void init(String inputFile) {
        final List<String> instructions = cardFileReader.readFile(inputFile);
        instructions.stream()
                .filter(instructionLine -> !instructionLine.startsWith("#"))
                .map(instructionLine -> instructionSplitter.splitPieces(instructionLine))
                .forEach(
                        this::workOnInstruction
                );
        final Optional<Integer> maximumMoves = adventurers.stream()
                .map(adventurer -> adventurer.getMoves().length())
                .max(Comparator.naturalOrder());
        maximumMoves.ifPresent(this::setNbPlays);
    }

    private void workOnInstruction(Instruction instruction) {
        String type = instruction.getType();
        instructionCommandMap.get(type).processInstruction(this, instruction);
    }

    public GameRepresentation gameRepresentation() {
        return new GameRepresentation(this);
    }

    public void play() {
        Stream.iterate(0, n -> n+ 1)
                .limit(nbPlays)
                .forEach(
                        run -> adventurers.forEach(
                                adventurer -> AdventurerDeplacement.move(adventurer, this, run)
                        )
                );
        adventurers
                .forEach(Adventurer::deleteMoves);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    public void addMountain(Mountain mountain) {
        mountains.add(mountain);
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void removeTreasure(Treasure treasure)  {
        treasures.remove(treasure);
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public Set<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(Set<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    public Optional<? extends Piece> gotAPiece(int abcisse, int ordonnee, Collection<? extends Piece> pieces) {
        return pieces.stream()
                .filter(piece -> abcisse == piece.getAbcisse()
                        && ordonnee == piece.getOrdonnee())
                .findAny();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(card, game.card) &&
                Objects.equals(mountains, game.mountains) &&
                Objects.equals(treasures, game.treasures) &&
                Objects.equals(adventurers, game.adventurers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, mountains, treasures, adventurers);
    }
    @Override
    public String toString() {
        return "Game{" +
                "card=" + card +
                ", mountains=" + mountains +
                ", treasures=" + treasures +
                ", adventurers=" + adventurers +
                '}';
    }

    public int getNbPlays() {
        return nbPlays;
    }

    public void setNbPlays(int nbPlays) {
        this.nbPlays = nbPlays;
    }
}
