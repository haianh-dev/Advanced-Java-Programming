package bai1.code;

abstract class Shape {
    protected int x;
    protected int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract public void erase();

    public void moveTo(int newX, int newY) {
        erase();
        x = newX;
        y = newY;
        draw();
    }

    abstract public void draw();
}

class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void erase() {
        System.out.println("Xoa hinh tron tai (" + x + ", " + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("Ve hinh tron tai (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10, 10);
        circle.moveTo(20, 20);
    }
}

class Square extends Shape {
    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Ve hinh vuong tai (" + x + "," + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xoa hinh vuong tai (" + x + "," + y + ")");
    }
}