package org.unihh.basecamp.g4.wiki.jobs.json.JSONWordCount;

import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

public class JSONWordCountJob implements WikiJob {

    private JobConf conf;

    @Override
    public void start(final String input, final String Output) {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("word-count-json", JSONWordCountJob.class, JSONWordCountMapper.class);
    }

    @Override
    public String getName() {
        return conf.getJobName();
    }
}
