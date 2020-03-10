package it.carbon.command;

import it.carbon.game.Game;
import it.carbon.model.Adventurer;
import it.carbon.model.Instruction;

public class AdventurerInstructionCommand extends PieceInstructionCommand {

    @Override
    public void executeInstruction(Game game, Instruction instruction) {
        String[] otherInfosToSplit = instruction.otherInfos().split("-");
        final String movesUnformatted = otherInfosToSplit[2];
        final Adventurer adventurer = new Adventurer(instruction.getX(),
                instruction.getY(),
                otherInfosToSplit[0],
                otherInfosToSplit[1],
                movesUnformatted);
        game.addAdventurer(adventurer);
    }
}
