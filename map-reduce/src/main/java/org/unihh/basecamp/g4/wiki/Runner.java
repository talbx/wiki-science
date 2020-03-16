package org.unihh.basecamp.g4.wiki;

/**
 * Starter class for map-reduce jobs
 */
public class Runner {

    /**
     * starts the application with provided arguments.
     * if no arguments provided, Runner will throw RuntimeException.
     * @param args - the job args
     */
    public static void main(String[] args) {
        JobExecutor executor = new JobExecutor(new JobFactory());
        System.out.println(args[0] + args[1] + args[2]);
        Arguments arguments = Arguments.of(args[0], args[1], args[2]);
        executor.accept(arguments);
    }
}