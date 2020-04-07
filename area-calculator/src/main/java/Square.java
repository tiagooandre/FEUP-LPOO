public class Square implements Shape {
    private Integer side;

    public Square(int side) {
        this.side = side;
    }

    public Integer getSide() {
        return side;
    }

    public double getArea() {
        return side*side;
    }

    public String draw() {
        return this.getClass().getName();
    }
}
