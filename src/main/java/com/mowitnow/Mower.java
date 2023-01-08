package com.mowitnow;

public class Mower {

    private final Field field;
    private Position position;
    private String direction;


    public Mower(Field field, Position position, String direction) {
        this.field = field;
        this.position = position;
        this.direction = direction;
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
