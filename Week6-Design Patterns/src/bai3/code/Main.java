package bai3.code;
import java.util.Scanner;

interface Button {
    void render();
}

interface CheckBox {
    void render();
}

interface UIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WindowButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a sleek Windows-style button with modern UI.");
    }
}

class WindowCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox with classic checkmark style.");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a smooth macOS button with elegant design.");
    }
}

class MacCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering a macOS checkbox with minimalistic aesthetics.");
    }
}

class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

public class Main {
    public static void main(String[] args) {
        UIFactory factory;

        Scanner sc = new Scanner(System.in);
        String config = sc.nextLine();

        if (config.equals("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        button.render();
        checkBox.render();
    }
}
