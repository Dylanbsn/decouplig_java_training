package fr.lernejo.logger;

public class LoggerFactory {

    private final static String path = "log.txt";

    public static Logger getLogger(String name) {
        return new CompositeLogger(new ContextualLogger(name, new FileLogger(path)), new ContextualLogger(name, new ConsoleLogger()));

    }
}
