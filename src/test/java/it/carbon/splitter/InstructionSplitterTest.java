package it.carbon.splitter;

import it.carbon.model.Instruction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionSplitterTest {

    InstructionSplitter instructionSplitter = new InstructionSplitter();

    @Test
    public void shouldSplitTheLineAndReturnAndInstruction() {

        //When
        Instruction instruction = instructionSplitter.splitPieces("C - 3 - 4");

        //Then
        assertEquals("C", instruction.getType());
        assertEquals(3, instruction.getX());
        assertEquals(4, instruction.getY());

        //And
        instruction = instructionSplitter.splitPieces("M - 1 - 0");
        //Then
        assertEquals("M", instruction.getType());
        assertEquals(1, instruction.getX());
        assertEquals(0, instruction.getY());

        //And
        instruction = instructionSplitter.splitPieces("T - 0 - 3 - 2");
        //Then
        assertEquals("T", instruction.getType());
        assertEquals(0, instruction.getX());
        assertEquals(3, instruction.getY());
        assertEquals("2", instruction.otherInfos());
        //And
        instruction = instructionSplitter.splitPieces("A - Lara - 1 - 1 - S - AADADAGGA");
        //Then
        assertEquals("A", instruction.getType());
        assertEquals(1, instruction.getX());
        assertEquals(1, instruction.getY());
        assertEquals("Lara-S-AADADAGGA", instruction.otherInfos());
    }
}
