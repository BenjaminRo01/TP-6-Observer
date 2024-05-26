package main;

import model.ConsoleClima;
import model.Medidor;
import model.RegistroEnDiscoClima;
import model.WeatherChannelService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String lat = "-40.8084"; //Adolfo Alsina, Rio Negro
        String lon = "-62.9947";
        String unidad = "metric"; //Celsius
        String keyApi = "d2038c709af19ed6bb5d8b191708bdaa";
        String path = "C:/Registros/RegistroTemperatura.txt";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + keyApi +"&units=" + unidad;
        Medidor medidor = new Medidor(new WeatherChannelService(url),
                List.of(new ConsoleClima(), new RegistroEnDiscoClima(path)));
        medidor.leerTemperatura();

    }
}
