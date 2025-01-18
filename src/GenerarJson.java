import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class GenerarJson {
    private static final String LOG_FILE = "registro_conversiones.log";

    public void archivo(DivisasApi convertido, String origen, String destino) throws IOException {
        // Configuracion GSon
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Crear Archivo Json
        String fileName = origen + "-" + destino + ".json";
        try (FileWriter escritura = new FileWriter(fileName)) {
            escritura.write(gson.toJson(convertido));
        }

        //Log de las conversiones
        registrarConversion(origen, destino);
    }

    private void registrarConversion(String origen, String destino) throws IOException {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format("[%s] Conversión realizada: %s -> %s%n", timestamp, origen, destino);

        // Escribe un log de conversiones con una huella de tiempo
        try (FileWriter logWriter = new FileWriter(LOG_FILE, true)) {
            logWriter.write(logMessage);
        }
    }
}

