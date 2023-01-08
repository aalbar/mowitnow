package com.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.mowitnow.Direction.E;
import static com.mowitnow.Direction.N;

class MowerCommandLineTest {

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

    @Test
    void should_read_file_and_execute_one_cycle_of_commands() throws URISyntaxException {

        //Given
        URL resource = getClass().getClassLoader().getResource("test1.txt");
        File file = new File(resource.toURI());

        //When
        MowerCommandLine mowerCommandLine = null;
        try {
            mowerCommandLine = new MowerCommandLine(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        Assertions.assertEquals(1, mowerCommandLine.getMower().getPosition().getX());
        Assertions.assertEquals(3, mowerCommandLine.getMower().getPosition().getY());
        Assertions.assertEquals(N, mowerCommandLine.getMower().getDirection());

    }

    @Test
    void should_read_file_and_execute_two_cycle_of_commands() throws URISyntaxException {

        //Given
        URL resource = getClass().getClassLoader().getResource("test2.txt");
        File file = new File(resource.toURI());

        //When
        MowerCommandLine mowerCommandLine = null;
        try {
            mowerCommandLine = new MowerCommandLine(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        Assertions.assertEquals(5, mowerCommandLine.getMower().getPosition().getX());
        Assertions.assertEquals(1, mowerCommandLine.getMower().getPosition().getY());
        Assertions.assertEquals(E, mowerCommandLine.getMower().getDirection());

    }

}
