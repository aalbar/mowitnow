package com.mowitnow;

import com.mowitnow.exception.InvalidPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.mowitnow.Direction.E;
import static com.mowitnow.Direction.N;

class MowerRunnerTest {

    @Test
    void should_read_file_and_execute_one_cycle_of_commands() throws URISyntaxException {

        //Given
        URL resource = getClass().getClassLoader().getResource("test1.txt");
        File file = new File(resource.toURI());

        //When
        MowerRunner mowerRunner = null;
        try {
            mowerRunner = new MowerRunner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        Assertions.assertEquals(1, mowerRunner.getMower().getPosition().getX());
        Assertions.assertEquals(3, mowerRunner.getMower().getPosition().getY());
        Assertions.assertEquals(N, mowerRunner.getMower().getDirection());

    }

    @Test
    void should_read_file_and_execute_two_cycle_of_commands() throws URISyntaxException {

        //Given
        URL resource = getClass().getClassLoader().getResource("test2.txt");
        File file = new File(resource.toURI());

        //When
        MowerRunner mowerRunner = null;
        try {
            mowerRunner = new MowerRunner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        Assertions.assertEquals(5, mowerRunner.getMower().getPosition().getX());
        Assertions.assertEquals(1, mowerRunner.getMower().getPosition().getY());
        Assertions.assertEquals(E, mowerRunner.getMower().getDirection());

    }


    @Test
    void should_read_file_with_bad_field_input() throws URISyntaxException {

        //Given
        URL resource = getClass().getClassLoader().getResource("test_invalid_position.txt");
        File file = new File(resource.toURI());

        //When
        MowerRunner mowerRunner = null;
        InvalidPositionException thrown = Assertions.assertThrows(InvalidPositionException.class, () -> new MowerRunner(file));

        //Then
        Assertions.assertEquals("Invalid Position Data", thrown.getMessage());

    }

}
