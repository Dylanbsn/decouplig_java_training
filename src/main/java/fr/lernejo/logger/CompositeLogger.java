package fr.lernejo.logger;

public class CompositeLogger implements Logger {

    private final Logger fileLogger;
    private final Logger consoleLogger;

    public CompositeLogger(Logger fileLogger, Logger consoleLogger) {
        this.fileLogger = fileLogger;
        this.consoleLogger = consoleLogger;
    }

    public void log(String message) {
        consoleLogger.log(message);
        fileLogger.log(message);
    }
}
