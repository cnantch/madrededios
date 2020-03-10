package it.carbon.command;

import it.carbon.game.Game;
import it.carbon.model.Card;
import it.carbon.model.Instruction;

public class CardInstructionCommand implements InstructionCommand {

    @Override
    public void processInstruction(Game game, Instruction instruction) {
        game.setCard(new Card(instruction.getX(), instruction.getY()));
    }
}
