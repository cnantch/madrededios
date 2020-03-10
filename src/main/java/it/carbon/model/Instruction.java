package it.carbon.model;

public class Instruction {

    private final String type;
    private final Integer x;
    private final Integer y;
    private final String otherInfos;

    public static final Instruction EMPTY = new Instruction("",0, 0, "");

    public Instruction(String type, Integer x, Integer y, String otherInfos) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.otherInfos = otherInfos;
    }

    public String getType() {
        return type;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public String otherInfos() {
        return otherInfos;
    }
}
