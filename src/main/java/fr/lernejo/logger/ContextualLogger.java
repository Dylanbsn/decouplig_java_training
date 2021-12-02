package fr.lernejo.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextualLogger implements Logger {

    private final String name;
    private final Logger logger;
    private String format = "yyyy-MM-dd HH:mm:ss.SSS";

    public ContextualLogger(String name, Logger logger) {
        this.name = name;
        this.logger = logger;
    }

    public void log(String message) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(format);
        Date now = new Date();
        String strDate = sdfDate.format(now);
        this.logger.log("[" + strDate + "] " + name + " > " + message);
    }
}
