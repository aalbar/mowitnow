package com.mowitnow;

public class Mower {

    private int fieldLength;

    private int fieldHeight;


    public void initField(String line) {
        String[] values = line.split(" ");
        this.fieldLength = Integer.parseInt(values[0]) + 1;
        this.fieldHeight = Integer.parseInt(values[1]) + 1;
    }

    public int getFieldLength() {
        return fieldLength;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }
}
