package bai7.code;

interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("[EmailNotifier] > " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    private Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String msg) {
        notifier.send(msg);
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("[SMSNotifier] > " + msg);
    }
}

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("[FacebookNotifier] > " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifier(new FacebookNotifier(new EmailNotifier()));
        notifier.send("Hello World!");
    }
}
