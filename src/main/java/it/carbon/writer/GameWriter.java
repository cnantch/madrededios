package it.carbon.writer;

import it.carbon.game.Game;
import it.carbon.game.GameRepresentation;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.writeString;

public class GameWriter {

    public void write(Game game, String outputFile) {
        try {
            final GameRepresentation gameRepresentation = new GameRepresentation(game);
            System.out.println(gameRepresentation.toString());
            writeString(Paths.get(outputFile),
                    gameRepresentation.representation(),
                    StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error occured during the writing of the output file");
            e.printStackTrace();
        }
    }
}
