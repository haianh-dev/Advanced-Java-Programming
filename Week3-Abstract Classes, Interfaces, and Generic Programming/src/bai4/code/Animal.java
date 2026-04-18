package bai4.code;

public class Animal {
    public String makeSound() {
        return "Animal sound";
    }

    public void main(String[] args) {
        Animal a = new Dog();

        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Day khong phai la Meo!");
        }
    }
}

class Dog extends Animal {
    public String makeSound() {
        return "Woof Woof";
    }
}

class Cat extends Animal {
    public String makeSound() {
        return "Meows Meows";
    }
}

class Duck extends Animal {
}

