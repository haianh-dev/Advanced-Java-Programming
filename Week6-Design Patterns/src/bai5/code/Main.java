package bai5.code;

// Yeu cau 1
class Logger {
    private static Logger logger;

    private Logger() {};

    public static synchronized Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}

// Yeu cau 2
interface Export {
    void export();
}

class PDFExport implements Export {
    @Override
    public void export() {
        System.out.println("[PROCESS] PDF generation successfully executed.");
    }
}

class ExcelExport  implements Export {
    @Override
    public void export() {
        System.out.println("[PROCESS] Excel generation successfully executed.");
    }
}

abstract class AppExport {
    public void notifyUser() {
        Export export = createNotification();
        export.export();
    }

    public abstract Export createNotification();
}

class PDF extends AppExport {
    @Override
    public Export createNotification() {
        return new PDFExport();
    }
}

class Excel extends AppExport {
    @Override
    public Export createNotification() {
        return new ExcelExport();
    }
}

// Yeu cau 3
class OldPlayer {
    void playFile(String name) { }
}

interface Player {
    void play(String name);
}

class Adaptor implements Player {
    private OldPlayer player;

    public Adaptor(OldPlayer player) {
        this.player = player;
    }

    @Override
    public void play(String name) {
        player.playFile(name);
        System.out.println("[INFO] Playing file: " + name + ".mp4...");
    }
}

// Yeu cau 4
class AppConfig {
    private String appName;
    private String version;
    private String logLevel;

    public AppConfig(String appName, String version, String logLevel) {
        this.appName = appName;
        this.version = version;
        this.logLevel = logLevel;
    }

    public AppConfig(AppConfig other) {
        this.appName = other.appName;
        this.version = other.version;
        this.logLevel = other.logLevel;
    }

    public String getAppName() {
        return appName;
    }
    public String getVersion() {
        return version;
    }
    public String getLogLevel() {
        return logLevel;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public void printInfo() {
        System.out.println("[" + appName + " v" + version + " | Log: " + logLevel + "]");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Kiem Tra Yeu Cau 1: ");
        Thread t1 = new Thread(() -> {
            Logger logger1 = Logger.getInstance();
            System.out.println("Luong 1 - HashCode: " + logger1.hashCode());
        });
        Thread t2 = new Thread(() -> {
            Logger logger2 = Logger.getInstance();
            System.out.println("Luong 2 - HashCode: " + logger2.hashCode());
        });

        t1.start();
        t2.start();

        // Phuc vu muc dich decor
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Phuc vu muc dich decor

        System.out.println();
        System.out.println("Kiem Tra Yeu Cau 2: ");
        AppExport export1 = new PDF();
        export1.notifyUser();
        AppExport export2 = new Excel();
        export2.notifyUser();

        System.out.println();
        System.out.println("Kiem Tra Yeu Cau 3: ");
        OldPlayer oldPlayer = new OldPlayer();
        Player player = new Adaptor(oldPlayer);
        player.play("video");

        System.out.println();
        System.out.println("Kiem Tra Yeu Cau 4: ");
        AppConfig config1 = new AppConfig("ProPlayer_v2", "1.0.4-STABLE", "DEBUG");
        AppConfig config2 = new AppConfig(config1);
        config2.setAppName("NoobPlayer_ver2");
        config1.printInfo();
        config2.printInfo();
    }
}
