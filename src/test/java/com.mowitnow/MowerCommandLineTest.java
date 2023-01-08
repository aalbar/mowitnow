package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

public class MowerCommandLineTest {

    @Test
    void should_read_file_and_init_mower() throws URISyntaxException {

        //Given
        URL resource = getClass().getClassLoader().getResource("test.txt");
        File file = new File(resource.toURI());

        //When
        MowerCommandLine mowerCommandLine = null;
        try {
            mowerCommandLine = new MowerCommandLine(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        Assertions.assertEquals(6, mowerCommandLine.getMower().getField().getLength());
        Assertions.assertEquals(2, mowerCommandLine.getMower().getPosition().getY());

    }
}
