import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{

    private List<HasArea> elements = new ArrayList<>();

    public void addShape(HasArea element) {
        elements.add(element);
    }

    public double sum() {
        double sum = 0;
        for (HasArea element: elements) {
//            if(shape.getClass().equals(Circle.class)) {
//                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
//            } else if (shape.getClass().equals(Square.class)) {
//                sum += Math.pow(((Square) shape).getSide(), 2);
//            } else if (shape instanceof Ellipse) {
//                sum += Math.PI * ((Ellipse) shape).getX_Radius() * ((Ellipse) shape).getY_Radius();
//            } else if (shape instanceof Rectangle) {
//                sum += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
//            } else if (shape instanceof Triangle) {
//                sum += ((Triangle) shape).getHeight() * ((Triangle) shape).getBase() / 2;
//            }
            sum += element.getArea();
        }
        return sum;
    }

//    public String output() {
//        return "Sum of areas: " + sum();
//    }
}
