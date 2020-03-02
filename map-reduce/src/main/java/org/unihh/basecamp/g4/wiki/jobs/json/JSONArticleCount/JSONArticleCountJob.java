package org.unihh.basecamp.g4.wiki.jobs.json.JSONArticleCount;

import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

public class JSONArticleCountJob implements WikiJob {

    private JobConf conf;

    @Override
    public void start(final String input, final String Output) {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("article-count-json", JSONArticleCountJob.class, JSONArticleCountMapper.class);
    }

    @Override
    public String getName() {
        return conf.getJobName();
    }
}
