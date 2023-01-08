package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mowitnow.Command.A;
import static com.mowitnow.Command.G;

class CommandConverterTest {

    @Test
    void should_convert_GAGAGAGAA_from_string_to_commands() {
        //Given
        String line = "GAGAGAGAA";

        //When
        List<Command> commands = CommandConverter.convert(line);

        //Then
        Assertions.assertEquals(G, commands.get(0));
        Assertions.assertEquals(A, commands.get(1));
        Assertions.assertEquals(G, commands.get(4));
        Assertions.assertEquals(A, commands.get(7));
    }
}
