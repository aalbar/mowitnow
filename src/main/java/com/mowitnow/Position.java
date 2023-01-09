package com.mowitnow;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isValidPosition(Field field) {
        return field != null && (this.x < field.getLength() - 1) && this.y < field.getHeight() - 1;
    }
}
