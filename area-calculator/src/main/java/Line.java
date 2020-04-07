public class Line implements BasicShape {
    private int length;

    public Line(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String draw() {
        return this.getClass().getName();
    }
}
