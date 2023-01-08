package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerTest {

    @Test
    void should_initiate_field_with_h5_and_l5() {
        //Given
        String line = "5 5";
        Mower mower;


        //When
        mower = new Mower(line);

        //Then
        Assertions.assertEquals(mower.getField().getLength(), 6);
        Assertions.assertEquals(mower.getField().getHeight(), 6);

    }
}
