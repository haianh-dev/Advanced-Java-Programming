package bai2.code;

interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

interface CanFight {
    void fight();
}

class ActionCharacter {
    public void fight() {
        System.out.println("Dam boc...");
    }
}

public class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {
    @Override
    public void fly() {
        System.out.println("Hero is flying");
    }

    @Override
    public void swim() {
        System.out.println("Hero is swimming");
    }

    public static void main(String[] args) {
        Hero hero = new Hero();

        CanSwim swim = (CanSwim) hero;
        swim.swim();

        CanFight fight = (CanFight) hero;
        fight.fight();
    }
}
