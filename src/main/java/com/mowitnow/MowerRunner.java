package com.mowitnow;

import com.mowitnow.exception.FieldLineNotFoundException;
import com.mowitnow.exception.InvalidPositionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MowerRunner {

    private Mower mower;

    public MowerRunner(File file) throws FileNotFoundException {
        run(file);
    }

    private void run(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Position position = null;
        Direction direction = null;
        List<Command> commands = null;

        if (!scanner.hasNextLine()) {
            throw new FieldLineNotFoundException("Field line is empty");
        }
        Field field = FieldConverter.convert(scanner.nextLine());

        int lineNumber = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (lineNumber % 2 == 1) {
                String[] values = line.split(" ");
                position = PositionConverter.convert(values);
                if (!position.isValidPosition(field)) {
                    throw new InvalidPositionException("Invalid Position Data");
                }
                direction = DirectionConverter.convert(values[2]);
            } else {
                commands = CommandConverter.convert(line);
                mower = new Mower(field, position, direction);
                mower.apply(commands);
                System.out.printf("Position %d %d %s%n", mower.getPosition().getX(), mower.getPosition().getY(), mower.getDirection());
            }
            lineNumber++;
        }
    }


    public Mower getMower() {
        return mower;
    }
}
