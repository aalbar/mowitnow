package com.mowitnow;

import java.util.ArrayList;
import java.util.List;

public class CommandConverter {

    public static List<Command> convert(String line) {
        String[] values = line.split("");
        List<Command> commands = new ArrayList<>();
        for (String a : values) {
            commands.add(Command.valueOf(a));
        }
        return commands;
    }
}
