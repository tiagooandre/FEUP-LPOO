public class Triangle implements Shape{
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public double getArea() {
        return height * base / 2;
    }

    public String draw() {
        return this.getClass().getName();
    }
}
