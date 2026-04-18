package bai10.code;
import java.io.*;
import java.util.*;

class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap duong dan file config: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));

            Map<String, String> configMap = new HashMap<>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configMap.put(key, value);
                }
            }

            validateConfig(configMap);

            System.out.println("Cau hinh doc duoc: " + configMap);
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Loi khi dong file.");
            }
            System.out.println("Program finished.");
        }
        scanner.close();
    }

    public static void validateConfig(Map<String, String> map) throws InvalidConfigException {
        if (!map.containsKey("username")) throw new InvalidConfigException("Missing username");
        if (!map.containsKey("timeout")) throw new InvalidConfigException("Missing timeout");

        try {
            int timeout = Integer.parseInt(map.get("timeout"));
            if (timeout <= 0) throw new InvalidConfigException("timeout must be > 0");
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if (map.containsKey("maxConnections")) {
            int maxConn = Integer.parseInt(map.get("maxConnections"));
            if (maxConn < 1) throw new InvalidConfigException("maxConnections must be >= 1");
        }
    }
}