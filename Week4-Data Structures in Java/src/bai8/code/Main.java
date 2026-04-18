package bai8.code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import  java.util.Scanner;

interface IWiFiConnectable {
    void connectWiFi();
}

interface ILevelAdjustable {
    void adjustLevel(int level);
}

class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    public Device(String id, String name, boolean isOn) {
        this.id = id;
        this.name = name;
        this.isOn = isOn;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println(name + " turned on");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(name + " turned off");
    }
}

class SmartLight extends Device implements ILevelAdjustable {
    public SmartLight(String id, String name, boolean isOn) {
        super(id, name, isOn);
    }

    @Override
    public void adjustLevel(int level) {
        System.out.println(name + " adjusted to level " + level);
    }
}

class AirConditioner extends Device implements IWiFiConnectable {
    public AirConditioner(String id, String name, boolean isOn) {
        super(id, name, isOn);
    }

    @Override
    public void connectWiFi() {
        System.out.println(name + " connected to wifi");
    }
}

class SmartSpeaker  extends Device implements ILevelAdjustable, IWiFiConnectable {
    public SmartSpeaker(String id, String name, boolean isOn) {
        super(id, name, isOn);
    }

    @Override
    public void adjustLevel(int level) {
        System.out.println(name + " adjusted to level " + level);
    }

    @Override
    public void connectWiFi() {
        System.out.println(name + " connected to wifi");
    }
}

class AutomaticCurtain  extends Device{
    public AutomaticCurtain(String id, String name, boolean isOn) {
        super(id, name, isOn);
    }
}

class Hub {
    private List<Device> deviceList;

    public Hub() {
    this.deviceList = new ArrayList<>();
    }

    public void addDevice(Device device) {
        this.deviceList.add(device);
    }

    public void turnOnAll() {
        for (Device device : this.deviceList) {
            device.turnOn();
        }
    }

    public void turnOffAll() {
        for (Device device : this.deviceList) {
            device.turnOff();
        }
    }

    public void setUpWifi() {
        for (Device device : this.deviceList) {
            if (device instanceof IWiFiConnectable) {
                IWiFiConnectable wiFiConnectable = (IWiFiConnectable) device;
                wiFiConnectable.connectWiFi();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong thiet bi: ");
        int n = sc.nextInt();
        Hub myhub = new Hub();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap loai, ma ID, ten, thiet bi: ");
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("L")) {
                myhub.addDevice(new SmartLight(id, name, false));
            } else if (type.equals("AC")) {
                myhub.addDevice(new AirConditioner(id, name, false));
            } else if (type.equals("S")) {
                myhub.addDevice(new SmartSpeaker(id, name, false));
            } else if (type.equals("C")) {
                myhub.addDevice(new AutomaticCurtain(id, name, false));
            }
        }

        System.out.println("Turn Off All Devices: ");
        myhub.turnOffAll();
        System.out.println();
        System.out.println("Setup Wifi: ");
        myhub.setUpWifi();
    }
}
