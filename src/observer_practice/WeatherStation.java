package observer_practice;
import java.util.ArrayList;

// Concrete implementation
public class WeatherStation implements Observable{

    private ArrayList<Observer> observers = new ArrayList<>();

    public Integer temp;
    public WeatherStation(Integer i) {
        temp=i;
    }

    @Override
    public void add(Observer o) {
        observers.add(o);

    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers() {

        for (Observer o : observers) {
            o.update();
        }

    }

    public void setTemp(Integer i) {
        temp=i;
        notifyObservers();
    }

    public Integer getTemp() {
        return temp;
    }
}
