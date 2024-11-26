package org.example.parser;

import java.time.LocalDateTime;

/*
Handle for cron expression parsing
 */
public class CronExpressionParser {
    private final String expression;
    private final int[] fields;

    public CronExpressionParser(String expression) {
        this.expression = expression;
        this.fields = parseExpression(expression);
    }

    private int[] parseExpression(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        // Total fields is 5
        int[] parsedFields = new int[5];
        for (int i = 0; i < parsedFields.length; i++) {
            parsedFields[i] = parts[i].equals("*") ? -1 : Integer.parseInt(parts[i]);
        }
        return parsedFields;
    }

    public boolean isMatch(LocalDateTime dateTime) {
        return (fields[0] == -1 || fields[0] == dateTime.getMinute()) &&
                (fields[1] == -1 || fields[1] == dateTime.getHour()) &&
                (fields[2] == -1 || fields[2] == dateTime.getDayOfMonth()) &&
                (fields[3] == -1 || fields[3] == dateTime.getMonthValue()) &&
                (fields[4] == -1 || fields[4] == dateTime.getDayOfWeek().getValue());
    }

    @Override
    public String toString() {
        return expression;
    }
}
