package it.carbon.reader;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CardFileReaderTest {

    CardFileReader cardFileReader = new CardFileReader();

    @Test
    public void shouldReadFileAnReturnTheInstructionsInTheFile() {

        //When
        List<String> instructions = cardFileReader.readFile("src/test/resources/inputFile");

        //Then
        Assertions.assertNotNull(instructions);
        Assertions.assertEquals("C - 3 - 4", instructions.get(0));
        Assertions.assertEquals("M - 1 - 1", instructions.get(1));
        Assertions.assertEquals("M - 2 - 2", instructions.get(2));
        Assertions.assertEquals("T - 0 - 3 - 2", instructions.get(3));
        Assertions.assertEquals("T - 1 - 3 - 1", instructions.get(4));
    }
}
