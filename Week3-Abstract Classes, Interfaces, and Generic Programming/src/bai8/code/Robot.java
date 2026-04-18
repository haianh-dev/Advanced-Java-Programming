package bai8.code;
import java.util.Scanner;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface GPS {
    void getCoordinates();
}

class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }

    public void turnOn() {
    }
}

class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    public void swim() {
        System.out.println(getModelName() + " swimming");
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    public void swim() {
        System.out.println(getModelName() + " swimming");
    }

    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

interface ElectronicDevice {
    void turnOn();
}

public abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery() {
        System.out.println("Da sac pin: 100%");
    }

    public void showIdentity(final int id, final String modelName) {
        System.out.println("ID cua ROBOT la: " + id);
        System.out.println("MODELNAME cua ROBOT la: " + modelName);
    }

    public abstract void performMainTask();

    public String getModelName() {
        return this.modelName;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong ROBOT: ");
        int robotCount = sc.nextInt();
        Robot[] robotList = new Robot[robotCount];

        for (int i = 0; i < robotCount; i++) {
            System.out.println("Nhap loai ROBOT: ");
            String robotType = sc.next();
            sc.nextLine();

            if (robotType.equals("DR")) {
                System.out.println("Nhap ID cua ROBOT: ");
                int id = sc.nextInt();
                System.out.println("Nhap MODELNAME cua ROBOT: ");
                String modelName = sc.next();
                sc.nextLine();
                robotList[i] = new DroneRobot(id, modelName);
            } else if (robotType.equals("FR")) {
                System.out.println("Nhap ID cua ROBOT: ");
                int id = sc.nextInt();
                System.out.println("Nhap MODELNAME cua ROBOT: ");
                String modelName = sc.next();
                sc.nextLine();
                robotList[i] = new FishRobot(id, modelName);
            } else if (robotType.equals("AR")) {
                System.out.println("Nhap ID cua ROBOT: ");
                int id = sc.nextInt();
                System.out.println("Nhap MODELNAME cua ROBOT: ");
                String modelName = sc.next();
                sc.nextLine();
                robotList[i] = new AmphibiousRobot(id, modelName);
            }
        }
        System.out.println();

        for (Robot robot : robotList) {
            robot.performMainTask();
            if (robot instanceof Flyable) {
                Flyable flySkill = (Flyable) robot;
                flySkill.fly();
            }

            if (robot instanceof Swimmable) {
                Swimmable swimSkill = (Swimmable) robot;
                swimSkill.swim();
            }

            if (robot instanceof GPS) {
                GPS gpsSkill = (GPS) robot;
                gpsSkill.getCoordinates();
            }
            System.out.println();
        }
    }
}
