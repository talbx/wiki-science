package org.unihh.basecamp.g4.wiki;

public class Runner {

    /**
     * @param args
     */
    public void main(String[] args) {

        if(args.length != 3) {
            this.printOptions();
        } else {
            // A fancy class loading factory would be cool here, but it was too late for that
            switch (args[0]) {
                case "--word-count-job":
                    WikiJob wordCountJob = new WordCountJob(args[1], args[2]);
                    wordCountJob.start();
                    break;
                default:
                    this.printOptions();
                    break;
            }
        }

    }

    /**
     * print options
     */
    public static void printOptions() {
        System.out.println("arg missmatch, choose one pattern from below:");
        System.out.println("--word-count-job input output");
    }
}