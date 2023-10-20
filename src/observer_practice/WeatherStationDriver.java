package observer_practice;

public class WeatherStationDriver {

    public static void main(String args[]) {
        WeatherStation ws = new WeatherStation(69);
        PhoneDisplay pd = new PhoneDisplay(ws);
        ws.add(pd);
        ws.setTemp(60);
        ws.setTemp(65);
        ws.setTemp(15);


    }
}
