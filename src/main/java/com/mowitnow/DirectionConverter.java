package com.mowitnow;

import com.mowitnow.exception.InvalidDirectionException;

public class DirectionConverter {

    private DirectionConverter() {
    }

    public static Direction convert(String value) {
        Direction direction;
        try {
            direction = Direction.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidDirectionException("Invalid Direction");
        }
        return direction;
    }
}
