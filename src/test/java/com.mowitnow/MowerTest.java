package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MowerTest {

    @Test
    void should_initiate_field_with_h5_and_l5() {
        //Given
        Mower mower;
        Field field = new Field(6, 6);


        //When
        mower = new Mower(field, null, null);

        //Then
        Assertions.assertEquals(6, mower.getField().getLength());
        Assertions.assertEquals(6, mower.getField().getHeight());

    }

    @Test
    void should_initiate_position_1_2_N_given_field_5_5() {
        //Given
        Position position = new Position(1, 2);
        String direction = "N";
        Mower mower;

        //When
        mower = new Mower(null, position, direction);

        //Then
        Assertions.assertEquals(1, mower.getPosition().getX());
        Assertions.assertEquals(2, mower.getPosition().getY());
        Assertions.assertEquals("N", mower.getDirection());

    }
}
