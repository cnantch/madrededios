package it.carbon.command;

import it.carbon.game.Game;
import it.carbon.model.Instruction;
import it.carbon.model.Treasure;

public class TreasureInstructionCommand extends PieceInstructionCommand {

    @Override
    public void executeInstruction(Game game, Instruction instruction) {
        int nbTreasures = Integer.parseInt(instruction.otherInfos());
        game.addTreasure(new Treasure(instruction.getX(), instruction.getY(), nbTreasures));
    }
}
