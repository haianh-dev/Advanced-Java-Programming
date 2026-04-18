package bai2.code;

public class Animal {
    public String makeSound() {
        return "Animal sound";
    }

    public void main(String[] args) {
        Animal [] zoo = new Animal[4];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();
        for (int i = 0; i < 4; i ++) {
            System.out.println(zoo[i].makeSound());
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


