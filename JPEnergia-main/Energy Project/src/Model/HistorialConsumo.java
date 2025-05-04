package Model;

import java.util.HashMap;
import java.util.Map;

public class HistorialConsumo {
    // Mapa: clave = "YYYY-MM-DD-HH", valor = consumo en kWh
    private Map<String, Double> consumos;

    public HistorialConsumo() {
        this.consumos = new HashMap<>();
    }
    
    // Registra un consumo en una fecha y hora específica
    public void registrarConsumo(String fechaHora, double consumo) {
        consumos.put(fechaHora, consumo);
    }

    // Obtiene el consumo en una fecha-hora dada
    public Double obtenerConsumo(String fechaHora) {
        return consumos.get(fechaHora);
    }

    // Modifica el valor del consumo registrado en una fecha-hora
    public void modificarConsumo(String fechaHora, double nuevoValor) {
        consumos.put(fechaHora, nuevoValor);
    }

    // Devuelve todos los consumos registrados
    public Map<String, Double> getConsumos() {
        return consumos;
    }
    
}
