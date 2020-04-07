import java.util.ArrayList;
import java.util.List;

public class Bar {
    private boolean happyHour;
    private List<BarObserver> observers;

    public Bar() {
        this.happyHour = happyHour;
        this.observers = new ArrayList<>();
    }

    public Bar (boolean happyHour) {
        this.happyHour = happyHour;
    }

    public boolean isHappyHour() {
        return happyHour;
    }

    public void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        for (BarObserver client : observers) {
            if (observer.equals(client)) {
                return;
            }
        }
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}