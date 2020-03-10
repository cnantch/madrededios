package it.carbon.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CardFileReader {
    public List<String> readFile(String inputFile) {
        try {
            return Files.readAllLines(Paths.get(inputFile));
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }
}
