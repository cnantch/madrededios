package it.carbon.command;

import it.carbon.game.Game;
import it.carbon.model.Card;
import it.carbon.model.Instruction;

public abstract class PieceInstructionCommand implements InstructionCommand {

    public void checkInstruction(Game game, Instruction instruction) {
        final Card card = game.getCard();
        if (card == null) {
            throw new IllegalStateException("Card must be init before other elements");
        }
        if (instruction.getX() < 0 || instruction.getX() >= card.getWidth()
                ||
            instruction.getY() < 0 || instruction.getY() >= card.getHeight()) {
            throw new IllegalStateException("The elements of the card must be in the card");
        }
    }

    public abstract void executeInstruction(Game game, Instruction instruction);

    @Override
    public void processInstruction(Game game, Instruction instruction) {
        checkInstruction(game, instruction);
        executeInstruction(game, instruction);
    }
}
