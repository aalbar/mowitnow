package com.mowitnow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MowerCommandLine {

    private Mower mower;

    public MowerCommandLine(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        Field field = null;
        Position position = null;
        Direction direction = null;
        List<Command> commands = null;

        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (lineNumber == 0) {
                field = initField(line);
            } else if (lineNumber == 1) {
                String[] values = line.split(" ");
                position = getPosition(values);
                direction = convertDirection(values);
            } else {

                commands = CommandConverter.convert(line);
            }
            lineNumber++;
        }
        mower = new Mower(field, position, direction);
        mower.apply(commands);
    }


    private Position getPosition(String[] values) {
        return new Position(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    private Field initField(String line) {
        String[] values = line.split(" ");
        return new Field(Integer.parseInt(values[0]) + 1, Integer.parseInt(values[1]) + 1);
    }

    private static Direction convertDirection(String[] values) {
        return Direction.valueOf(values[2]);
    }

    public Mower getMower() {
        return mower;
    }
}
