import java.util.List;

public class City implements SumProvider {
    private List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    public List<House> getHouses() {
        return houses;
    }

    public double sum() {
        double areaH = 0;
        for (House house: houses) {
            areaH += house.getArea();
        }
        return areaH;
    }
}
