package com.mowitnow;

import java.util.List;

public class Mower {

    private final Field field;
    private Position position;
    private Direction direction;


    public Mower(Field field, Position position, Direction direction) {
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

    public Direction getDirection() {
        return direction;
    }

    public void apply(List<Command> commands) {
        for (Command command : commands) {
            switch (command) {
                case G -> this.direction = this.direction.getLeft();
                case D -> this.direction = this.direction.getRight();
                case A -> move();
            }
        }
    }

    private void move() {
        switch (direction) {
            case E -> {
                if (this.position.getX() < field.getLength() - 1) {
                    this.position = new Position(position.getX() + 1, position.getY());
                }
            }
            case W -> {
                if (this.position.getX() > 0) {
                    this.position = new Position(position.getX() - 1, position.getY());
                }
            }
            case N -> {
                if (this.position.getY() < field.getLength() - 1) {
                    this.position = new Position(position.getX(), position.getY() + 1);
                }
            }
            case S -> {
                if (this.position.getY() > 0) {
                    this.position = new Position(position.getX(), position.getY() - 1);
                }
            }
        }
    }
}
