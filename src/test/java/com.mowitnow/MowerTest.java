package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerTest {

    @Test
    void should_initiate_field_with_h5_and_l5() {
        //Given
        String line = "5 5";
        Mower mower = new Mower();


        //When
        mower.initField(line);

        //Then
        Assertions.assertEquals(mower.getFieldLength(), 6);
        Assertions.assertEquals(mower.getFieldHeight(), 6);

    }
}
