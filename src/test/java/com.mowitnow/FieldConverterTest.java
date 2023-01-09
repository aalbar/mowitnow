package com.mowitnow;

import com.mowitnow.exception.FieldLineNotFoundException;
import com.mowitnow.exception.InvalidFieldLineException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldConverterTest {

    @Test
    void should_convert_field_line_5_5() {
        //Given
        String line = "5 5";

        //When
        Field field = FieldConverter.convert(line);

        //Then
        Assertions.assertEquals(6, field.getLength());
        Assertions.assertEquals(6, field.getHeight());
    }

    @Test
    void should_convert_field_line_2_7() {
        //Given
        String line = "2 7";

        //When
        Field field = FieldConverter.convert(line);

        //Then
        Assertions.assertEquals(3, field.getLength());
        Assertions.assertEquals(8, field.getHeight());
    }

    @Test
    void should_convert_field_line_null() {
        //Given
        String line = null;

        //When
        FieldLineNotFoundException thrown = Assertions.assertThrows(FieldLineNotFoundException.class, () -> FieldConverter.convert(line));

        //Then
        Assertions.assertEquals("Field line is empty", thrown.getMessage());
    }

    @Test
    void should_convert_field_line_invalid() {
        //Given
        String line = "5 null";

        //When
        InvalidFieldLineException thrown = Assertions.assertThrows(InvalidFieldLineException.class, () -> FieldConverter.convert(line));

        //Then
        Assertions.assertEquals("Invalid Filed Line", thrown.getMessage());
    }


}
