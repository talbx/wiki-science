package org.unihh.basecamp.g4.wiki.jobs;

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
