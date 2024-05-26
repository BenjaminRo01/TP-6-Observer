package main;

import model.Medidor;
import model.WeatherChannelService;

public class Main {
    public static void main(String[] args) {
        String lat = "-40.8084"; //Adolfo Alsina, Rio Negro
        String lon = "-62.9947";
        String unidad = "metric"; //Celsius
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=d2038c709af19ed6bb5d8b191708bdaa&units=" + unidad;
        Medidor medidor = new Medidor(new WeatherChannelService(url));
        System.out.println(medidor.leerTemperatura());



    }
}
