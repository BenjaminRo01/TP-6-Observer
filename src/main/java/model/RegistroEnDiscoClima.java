package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroEnDiscoClima implements Observer{
    private String path;

    public RegistroEnDiscoClima(String path) {
        this.path = path;
    }

    @Override
    public void actualizarTemperatura(String temperatura) {
        try {
            String registro = "Temperatura: " + temperatura + "°C " + "Fecha de consulta: " +
                    DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()) + "\n";
            Files.write(Paths.get(this.path),
                    registro.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
