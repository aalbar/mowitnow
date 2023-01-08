package com.mowitnow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MowerCommandLine {

    private Mower mower;

    public MowerCommandLine(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        Field field = null;
        Position position = null;
        String direction = null;

        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (lineNumber == 0) {
                field = initField(line);
            } else {
                String[] values = line.split(" ");
                position = getPosition(values);
                direction = values[2];
            }
            lineNumber++;
        }
        mower = new Mower(field, position, direction);
    }

    private static Position getPosition(String[] values) {
        return new Position(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    private Field initField(String line) {
        String[] values = line.split(" ");
        return new Field(Integer.parseInt(values[0]) + 1, Integer.parseInt(values[1]) + 1);
    }

    public Mower getMower() {
        return mower;
    }
}
