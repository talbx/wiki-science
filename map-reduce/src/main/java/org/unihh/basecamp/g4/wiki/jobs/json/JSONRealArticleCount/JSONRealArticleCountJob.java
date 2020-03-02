package org.unihh.basecamp.g4.wiki.jobs.json.JSONRealArticleCount;

import org.apache.hadoop.mapred.JobConf;
import org.unihh.basecamp.g4.wiki.ConfGenerator;
import org.unihh.basecamp.g4.wiki.jobs.WikiJob;

public class JSONRealArticleCountJob implements WikiJob {

    private JobConf conf;

    @Override
    public void start(final String input, final String Output) {
        ConfGenerator confGenerator = new ConfGenerator();
        conf = confGenerator.generateTextIntConf("real-article-count-json", JSONRealArticleCountJob.class, JSONRealArticleCountMapper.class);
    }

    @Override
    public String getName() {
        return conf.getJobName();
    }
}
