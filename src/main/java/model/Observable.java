package model;

import java.util.ArrayList;
import java.util.List;

abstract class Observable {
    private List<Observer> observadores;
    public Observable(){
        this.observadores = new ArrayList<>();
    }
    protected void agregarObserver(Observer observer){ //Se "suscriben"
        this.observadores.add(observer);
    }
    protected void notificarTemperaturaAObservers(String temperatura){
        this.observadores.forEach(o -> o.actualizarTemperatura(temperatura));
    }
}
