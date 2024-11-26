package org.example.scheduler;

import org.example.parser.CronExpressionParser;
import org.example.tasks.CronTask;

import java.time.LocalDateTime;

public class CronScheduler {
    private final CronTask cronTask;
    private final CronExpressionParser cronExpressionParser;

    public CronScheduler(CronTask cronTask, CronExpressionParser cronExpressionParser) {
        this.cronTask = cronTask;
        this.cronExpressionParser = cronExpressionParser;
    }

    public boolean shouldRun(LocalDateTime dateTime) {
        return cronExpressionParser.isMatch(dateTime);
    }

    public void execute() {
        cronTask.execute();
    }

    @Override
    public String toString() {
        return "Task scheduled with cron: " + cronExpressionParser;
    }
}
