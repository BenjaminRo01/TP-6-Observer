package model;

public class ConsoleClima implements Observer{

    public static final int TEMPERATURA_FRIO = 12;
    public static final int TEMPERATURA_CALOR = 17;

    @Override
    public void actualizarTemperatura(String temperatura) {
        double temperaturaDouble = Double.parseDouble(temperatura);
        if(temperaturaDouble < TEMPERATURA_FRIO){
            System.out.println("Hace frio, se encenderá la caldera");
        }
        else if (temperaturaDouble > TEMPERATURA_CALOR){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }
}
