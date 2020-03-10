package it.carbon.splitter;

import it.carbon.model.Instruction;

public class InstructionSplitter {

    public Instruction splitPieces(String line) {
        String[] pieces =  line.split("-");
        System.out.println("Pieces " +  pieces[0]);
        final String type = pieces[0].trim();
        final String sndEltOfLine = pieces[1].trim();
        final String thirdEltOfLine = pieces[2].trim();
        if ("C".equals(type) || "M".equals(type)
                ) {
            return new Instruction(type, Integer.valueOf(sndEltOfLine), Integer.valueOf(thirdEltOfLine),
                    "");
        } else {
            final String fourthEltOfLine = pieces[3].trim();
            if ("T".equals(type)) {
                return new Instruction(type, Integer.valueOf(sndEltOfLine), Integer.valueOf(thirdEltOfLine),
                        fourthEltOfLine);
            } else if ("A".equals(type)) {
                String otherInfos = String.join("-", sndEltOfLine, pieces[4].trim(), pieces[5].trim());
                return new Instruction(type, Integer.valueOf(thirdEltOfLine), Integer.valueOf(fourthEltOfLine),
                        otherInfos);
            }
        }
        return Instruction.EMPTY;
    }
}
