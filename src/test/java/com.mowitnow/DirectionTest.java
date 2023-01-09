package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    void should_turn_left() {
        Assertions.assertEquals(Direction.S, Direction.W.getLeft());
        Assertions.assertEquals(Direction.E, Direction.S.getLeft());
        Assertions.assertEquals(Direction.N, Direction.E.getLeft());
        Assertions.assertEquals(Direction.W, Direction.N.getLeft());
    }

    @Test
    void should_turn_right() {
        Assertions.assertEquals(Direction.N, Direction.W.getRight());
        Assertions.assertEquals(Direction.W, Direction.S.getRight());
        Assertions.assertEquals(Direction.S, Direction.E.getRight());
        Assertions.assertEquals(Direction.E, Direction.N.getRight());
    }
}
