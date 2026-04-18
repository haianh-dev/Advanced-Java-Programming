package bai2.code;

interface Notification {
    void send(String msg);
}

class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Dang gui Email voi noi dung: " + msg);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Dang gui SMS voi noi dung: " + msg);
    }
}

abstract class NotificationApp {
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }

    public abstract Notification createNotification();
}

class EmailApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationApp myApp = new EmailApp();
        myApp.notifyUser("Chao ban qua Email!");
    }
}
