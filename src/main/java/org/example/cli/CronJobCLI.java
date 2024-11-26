package org.example.cli;

import org.example.parser.CronExpressionParser;
import org.example.scheduler.CronScheduler;
import org.example.scheduler.ScheduledTask;

import java.util.Scanner;

public class CronJobCLI {
    private final CronScheduler scheduler;

    public CronJobCLI(CronScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task\n2. List Tasks\n3. Exit\nChoose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter cron expression (e.g., * * * * *):");
                    String expression = scanner.nextLine();
                    System.out.println("Enter task name:");
                    String taskName = scanner.nextLine();
                    CronExpressionParser cronExpressionParser = new CronExpressionParser(expression);
                    scheduler.registerTask(new ScheduledTask(cronExpressionParser, () -> {
                        System.out.println("Running task: " + taskName);
                    }));
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.println("Scheduled Tasks:");
                    for (ScheduledTask task : scheduler.getScheduledTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
