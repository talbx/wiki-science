package org.unihh.basecamp.g4.wiki.jobs;

/**
 * Basic Job for map-reduce operations
 */
public interface WikiJob {

    /**
     * dispatch the WikiJob to hadoop
     */
    void start(String input, String Output);

    /**
     * returns the job name
     *
     * @return jobname
     */
    String getName();

}
