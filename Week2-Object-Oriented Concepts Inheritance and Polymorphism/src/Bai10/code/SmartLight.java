package Bai10.code;

class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.println("[HUB] Dang ket noi voi thiet bi: " + light.getName());
    }
}

public class SmartLight {
    private String id;
    private String name;
    private int brightness;

    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness= brightness;
    }

    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public void setBrightness(String preset) {
        if ("MAX".equals(preset)) {
            this.setBrightness(100);
        } else if ("MIN".equals(preset)) {
            this.setBrightness(10);
        } else if ("ECO".equals(preset)) {
            this.setBrightness(30);
        } else {
            System.out.println("[Loi] Che do khong hop le!");
        }
    }

    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }

    public String getName() {
        return this.name;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public static void main(String[] args) {
        CentralHub hub = new CentralHub();

        SmartLight l1 = new SmartLight("L01", "den phong khach", 80);
        SmartLight l2 = new SmartLight("L02", "den ngu");

        l2.setBrightness("ECO");

        l1.connectToHub(hub);
        l2.connectToHub(hub);

        System.out.println("\nDo sang hien tai cua 2 den la: ");
        System.out.println("Do sang cua " + l1.getName() + " la: " + l1.getBrightness());
        System.out.println("Do sang cua " + l2.getName() + " la: " + l2.getBrightness());
    }
}


