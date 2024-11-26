package org.example.scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CronScheduler {
    private final List<ScheduledTask> scheduledTasks = new ArrayList<>();
    private volatile boolean running = true;

    public void registerTask(ScheduledTask task) {
        scheduledTasks.add(task);
    }

    public void start() {
        // Start the thread that will run every minute
        new Thread(() -> {
            while (running) {
                LocalDateTime dateTime = LocalDateTime.now();
                for(ScheduledTask scheduledTask : scheduledTasks) {
                    if (scheduledTask.shouldRun(dateTime)) {
                        // Run and execute the task
                        scheduledTask.execute();
                    }
                }
                try {
                    // 1 minute
                    Thread.sleep(60000 - (System.currentTimeMillis() % 60000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    public List<ScheduledTask> getScheduledTasks() {
        return scheduledTasks;
    }

    public void stop() {
        running = false;
    }
}
