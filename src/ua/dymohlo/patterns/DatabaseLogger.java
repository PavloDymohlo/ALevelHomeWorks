package ua.dymohlo.patterns;

import lombok.ToString;

@ToString
public class DatabaseLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("Logging to database");
    }
}
