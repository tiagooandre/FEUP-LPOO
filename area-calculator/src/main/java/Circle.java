public class Circle implements Shape {
    private Integer radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Integer getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String draw() {
        return this.getClass().getName();
    }
}
