package it.carbon.command;

import it.carbon.game.Game;
import it.carbon.model.Instruction;
import it.carbon.model.Mountain;

public class MountainInstructionCommand extends PieceInstructionCommand {

    @Override
    public void executeInstruction(Game game, Instruction instruction) {
        game.addMountain(new Mountain(instruction.getX(), instruction.getY()));
    }
}
