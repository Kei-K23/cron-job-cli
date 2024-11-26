package org.example;

import org.example.cli.CronJobCLI;
import org.example.scheduler.CronScheduler;

public class Main {
    public static void main(String[] args) {
        CronScheduler scheduler = new CronScheduler();
        CronJobCLI cli = new CronJobCLI(scheduler);

        // Start the CLI and scheduler
        new Thread(scheduler::start).start();
        cli.start();
    }
}