package org.unihh.basecamp.g4.wiki.jobs;

import org.springframework.stereotype.Component;

@Component
public class SampleJob implements WikiJob {

    @Override
    public void start(final String input, final String Output) {
        String x = "abc";
    }
}
