package org.unihh.basecamp.g4.wiki;

import org.immutables.value.Value;

@Value.Immutable
public interface Arguments {

    String getJob();

    String getInput();

    String getOutput();

    static ImmutableArguments of(String job, String input, String output) {
        return ImmutableArguments.builder()
                .job(job)
                .input(input)
                .output(output)
                .build();
    }
}
