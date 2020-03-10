package it.carbon;

import it.carbon.game.Game;
import it.carbon.writer.GameWriter;

import java.util.Scanner;

import static java.lang.String.format;

public class TreasuresCard {

    public static void main(String[] args) {
        System.out.println("Entrez le nom du fichier d'entrée : \n");
        String inputFileName = new Scanner(System.in).next();
        Game game = new Game();
        game.init(inputFileName);
        game.play();
        String outputFileName = format("%s-output", inputFileName);
        System.out.println(format("Le fichier de sortie se trouve à cet emplacement %s ", outputFileName));
        GameWriter gameWriter = new GameWriter();
        gameWriter.write(game, outputFileName);
    }
}
