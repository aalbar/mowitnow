package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MowerTest {

    @Test
    void should_initiate_field_with_h5_and_l5() {
        //Given
        String line = "5 5";
        Mower mower;


        //When
        mower = new Mower(line, "0 0 L");

        //Then
        Assertions.assertEquals(6, mower.getField().getLength());
        Assertions.assertEquals(6, mower.getField().getHeight());

    }

    @Test
    void should_initiate_position_1_2_N_given_field_5_5() {
        //Given
        String line = "5 5";
        String line2 = "1 2 N";
        Mower mower;

        //When
        mower = new Mower(line, line2);

        //Then
        Assertions.assertEquals(1, mower.getPosition().getX());
        Assertions.assertEquals(2, mower.getPosition().getY());
        Assertions.assertEquals("N", mower.getDirection());

    }
}
