package com.mowitnow;

public class Mower {

    private final Field field;


    public Mower(String line) {
        field = initfield(line);
    }

    private Field initfield(String line) {
        String[] values = line.split(" ");
        return new Field(Integer.parseInt(values[0]) + 1, Integer.parseInt(values[1]) + 1);
    }

    public Field getField() {
        return field;
    }

}
