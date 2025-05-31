package Controller;

import Model.ConsumoEnergia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConsumoControlador {
    private Map<String, List<ConsumoEnergia>> consumosPorMes;

    public ConsumoControlador(ArrayList arrayList) {
        consumosPorMes = new HashMap<>();
        inicializarMeses();
    }

    public ConsumoControlador() {
        consumosPorMes = new HashMap<>();
        inicializarMeses();
    }

    private void inicializarMeses() {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (String mes : meses) {
            consumosPorMes.put(mes, new ArrayList<>());
        }
    }

    public void agregarConsumo(String mes, ConsumoEnergia consumo) {
        if (consumosPorMes.containsKey(mes)) {
            consumosPorMes.get(mes).add(consumo);
        }
    }

    public List<ConsumoEnergia> obtenerConsumosPorMes(String mes) {
        return consumosPorMes.getOrDefault(mes, new ArrayList<>());
    }

    public void mostrarConsumos(String mes) {
        List<ConsumoEnergia> consumos = obtenerConsumosPorMes(mes);
        if (consumos.isEmpty()) {
            System.out.println("No hay consumos registrados para " + mes);
        } else {
            for (ConsumoEnergia c : consumos) {
                System.out.println(c);
            }
        }
    }

    public boolean modificarConsumo(String mes, String dia, int hora, String numeroContador, String numeroCliente, double nuevoKwh) {
        List<ConsumoEnergia> consumos = obtenerConsumosPorMes(mes);
        for (ConsumoEnergia consumo : consumos) {
            if (consumo.getDia().equals(dia) &&
                consumo.getHora() == hora &&
                consumo.getNumeroContador().equals(numeroContador) &&
                consumo.getNumeroIdentificacionCliente().equals(numeroCliente)) {
                consumo.setKwh(nuevoKwh);
                return true;
            }
        }
        return false;
    }

    public Map<String, Double> obtenerConsumoPorFranja(String numeroCliente) {
        Map<String, Double> consumoPorFranja = new HashMap<>();
        consumoPorFranja.put("Madrugada (0-6)", 0.0);
        consumoPorFranja.put("Día (7-17)", 0.0);
        consumoPorFranja.put("Noche (18-23)", 0.0);

        for (List<ConsumoEnergia> listaConsumos : consumosPorMes.values()) {
            for (ConsumoEnergia consumo : listaConsumos) {
                if (consumo.getNumeroIdentificacionCliente().equals(numeroCliente)) {
                    int hora = consumo.getHora();
                    double kwh = consumo.getKwh();
                    if (hora >= 0 && hora <= 6) {
                        consumoPorFranja.put("Madrugada (0-6)", consumoPorFranja.get("Madrugada (0-6)") + kwh);
                    } else if (hora >= 7 && hora <= 17) {
                        consumoPorFranja.put("Día (7-17)", consumoPorFranja.get("Día (7-17)") + kwh);
                    } else if (hora >= 18 && hora <= 23) {
                        consumoPorFranja.put("Noche (18-23)", consumoPorFranja.get("Noche (18-23)") + kwh);
                    }
                }
            }
        }
        return consumoPorFranja;
    }

    public Map<String, Double> obtenerConsumoPorDia(String numeroCliente) {
        Map<String, Double> consumoPorDia = new HashMap<>();
        for (List<ConsumoEnergia> listaConsumos : consumosPorMes.values()) {
            for (ConsumoEnergia consumo : listaConsumos) {
                if (consumo.getNumeroIdentificacionCliente().equals(numeroCliente)) {
                    String dia = consumo.getDia();
                    consumoPorDia.put(dia, consumoPorDia.getOrDefault(dia, 0.0) + consumo.getKwh());
                }
            }
        }
        return consumoPorDia;
    }

    public ConsumoEnergia obtenerConsumoMinimoPorMes(String mes, String numeroCliente) {
        List<ConsumoEnergia> consumos = obtenerConsumosPorMes(mes);
        if (consumos.isEmpty()) {
            return null; // No hay consumos registrados
        }

        return consumos.stream()
                .filter(consumo -> consumo.getNumeroIdentificacionCliente().equals(numeroCliente))
                .min((c1, c2) -> Double.compare(c1.getKwh(), c2.getKwh()))
                .orElse(null);
    }

    public ConsumoEnergia obtenerConsumoMaximoPorMes(String mes, String numeroCliente) {
        List<ConsumoEnergia> consumos = obtenerConsumosPorMes(mes);
        if (consumos.isEmpty()) {
            return null; // No hay consumos registrados
        }

        return consumos.stream()
                .filter(consumo -> consumo.getNumeroIdentificacionCliente().equals(numeroCliente))
                .max((c1, c2) -> Double.compare(c1.getKwh(), c2.getKwh()))
                .orElse(null);
    }
    public double calcularValorFactura(String mes, String numeroCliente) {
        double total = 0;
        List<ConsumoEnergia> consumos = obtenerConsumosPorMes(mes);
    
        for (ConsumoEnergia consumo : consumos) {
            if (consumo.getNumeroIdentificacionCliente().equals(numeroCliente)) {
                int hora = consumo.getHora();
                double tarifa = 0;
    
                if (hora >= 0 && hora <= 6) {
                    tarifa = 100;
                } else if (hora >= 7 && hora <= 17) {
                    tarifa = 200;
                } else if (hora >= 18 && hora <= 23) {
                    tarifa = 150;
                }
    
                total += consumo.getKwh() * tarifa;
            }
        }
    
        return total;
    }
    public Map<String, Double> getDatosParaGrafico(String clienteId) {
    Map<String, Double> datos = new LinkedHashMap<>();
    // Lógica para procesar consumos
    return datos;
}
    
}

