package org.unihh.basecamp.g4.wiki;

public class Runner {

    public static void main(String[] args) {
        JobExecutor executor = new JobExecutor(new JobFactory());
        System.out.println(args[0] + args[1] + args[2]);
        Arguments arguments = Arguments.of(args[0], args[1], args[2]);
        executor.accept(arguments);
    }
}