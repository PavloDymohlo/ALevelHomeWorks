package ua.dymohlo.patterns;

public class LoggerFactory {
    public Logger createLogger(LogType type) {
        Logger logger = null;

        switch (type) {
            case FILELOGGER:
                logger = new FileLogger();
                break;

            case EMAILLOGGER:
                logger = new EmailLogger();
                break;

            case DATABASELOGGER:
                logger = new DatabaseLogger();
                break;
        }
        return logger;
    }
}
