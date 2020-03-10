package it.carbon.command;

import it.carbon.game.Game;
import it.carbon.model.Instruction;

public interface InstructionCommand {

    void processInstruction(Game game, Instruction instruction);
}
