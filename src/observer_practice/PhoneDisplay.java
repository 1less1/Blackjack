package observer_practice;

public class PhoneDisplay implements Observer{

    public WeatherStation station;

    public PhoneDisplay(WeatherStation station) {
        this.station=station;
    }

    @Override
    public void update() {
        System.out.println(station.getTemp());


    }
}
