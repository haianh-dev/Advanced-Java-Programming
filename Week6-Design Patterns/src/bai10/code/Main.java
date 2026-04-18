package bai10.code;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Logger instances equal: true");
        } else {
            System.out.println("Logger instances equal: false");
        }

        logger1.logInfo("Application started");
        logger1.logInfo("Processing data...");
        logger1.logError("Something went wrong");
    }
}
