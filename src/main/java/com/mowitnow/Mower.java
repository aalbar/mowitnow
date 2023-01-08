package com.mowitnow;

public class Mower {

    private final Field field;
    private Position position;
    private String direction;


    public Mower(String line, String line2) {
        field = initfield(line);
        initPositionAndDirection(line2);
    }


    private Field initfield(String line) {
        String[] values = line.split(" ");
        return new Field(Integer.parseInt(values[0]) + 1, Integer.parseInt(values[1]) + 1);
    }

    private void initPositionAndDirection(String line2) {
        String[] values = line2.split(" ");
        this.position = new Position(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        this.direction = values[2];
    }

    public Field getField() {
        return field;
    }

    public Position getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }
}
