package org.unihh.basecamp.g4.wiki;

import org.immutables.value.Value;

@Value.Immutable
public interface Arguments {

    String getJob();

    String getInput();

    String getOutput();

    static ImmutableArguments of(String[] args) {
        if (args.length < 3) {
            throw new IllegalStateException("There must be a minimum of 3 vm arguments in order to run the application:\n" +
                    "1. job name, 2. inputfile, 3. outputfile");
        }
        return ImmutableArguments.builder()
                .job(args[0])
                .input(args[1])
                .output(args[2])
                .build();
    }
}
