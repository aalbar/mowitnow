package com.mowitnow;

import com.mowitnow.exception.InvalidCommandException;

import java.util.ArrayList;
import java.util.List;


public class CommandConverter {

    private CommandConverter() {
    }

    public static List<Command> convert(String line) {
        String[] values = line.split("");
        List<Command> commands = new ArrayList<>();
        for (String a : values) {
            try {
                commands.add(Command.valueOf(a));
            } catch (IllegalArgumentException e) {
                throw new InvalidCommandException("Invalid Command");
            }
        }
        return commands;
    }
}
