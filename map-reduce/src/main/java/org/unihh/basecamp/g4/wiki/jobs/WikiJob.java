package org.unihh.basecamp.g4.wiki.jobs;

import org.apache.hadoop.mapred.JobConf;

/**
 * WikiJob Interface
 */
public interface WikiJob {

    /**
     * dispatch the WikiJob to hadoop
     */
    void start(String input, String Output);

    /**
     * returns the job name
     * @return
     */
    String getName();

}
