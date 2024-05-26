package model;

import java.util.List;

public class Medidor extends Observable{
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima, List<Observer> observers) {
        this.clima = clima;
        for(Observer o : observers){
            this.agregarObserver(o);
        }
    }

    public void leerTemperatura() {
        //leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        this.notificarTemperaturaAObservers(this.temperatura);
    }
}