package Controller;

import Model.ConsumoEnergia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumoControlador {
    private Map<String, List<ConsumoEnergia>> consumosPorMes;

    public ConsumoControlador(ArrayList arrayList) {
        consumosPorMes = new HashMap<>();
        inicializarMeses();
    }

    public ConsumoControlador() {
        //TODO Auto-generated constructor stub
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
}
