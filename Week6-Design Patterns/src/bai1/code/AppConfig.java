package bai1.code;

class AppConfig {
    private static AppConfig instance;
    private String appName;
    private String version;
    private String logLevel;

    private AppConfig() {
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getLogLevel() { return logLevel; }
    public void setLogLevel(String logLevel) { this.logLevel = logLevel; }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            AppConfig config1 = AppConfig.getInstance();
            System.out.println("Luong 1 - HashCode: " + config1.hashCode());
        });
        Thread t2 = new Thread(() -> {
            AppConfig config2 = AppConfig.getInstance();
            System.out.println("Luong 2 - HashCode: " + config2.hashCode());
        });

        t1.start();
        t2.start();
    }
}
