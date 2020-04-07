public class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getArea() {
        return width * height;
    }

    public String draw() {
        return this.getClass().getName();
    }
}
