package Controller;

import Model.InformacionContadores;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContadoresControlador {
    private List<InformacionContadores> listaContadores;

    /**
     * Constructor que inicializa el controlador con una lista de contadores.
     * @param listaContadores Lista inicial de contadores.
     */
    public ContadoresControlador(List<InformacionContadores> listaContadores) {
        this.listaContadores = new ArrayList<>(listaContadores);
    }

    /**
     * Agrega un contador a la lista.
     * @param contador Contador a agregar.
     */
    public void agregarContador(InformacionContadores contador) {
        listaContadores.add(contador);
    }

    /**
     * Elimina un contador de la lista.
     * @param contador Contador a eliminar.
     */
    public void eliminarContador(InformacionContadores contador) {
        listaContadores.remove(contador);
    }

    /**
     * Modifica un contador existente en la lista.
     * @param contador Contador con la información actualizada.
     */
    public void modificarContador(InformacionContadores contador) {
        for (int i = 0; i < listaContadores.size(); i++) {
            if (listaContadores.get(i).getNumeroContador().equals(contador.getNumeroContador())) {
                listaContadores.set(i, contador);
                break;
            }
        }
    }

    /**
     * Busca un contador por su número.
     * @param numeroContador Número del contador a buscar.
     * @return El contador encontrado o null si no existe.
     */
    public InformacionContadores buscarContador(String numeroContador) {
        for (InformacionContadores contador : listaContadores) {
            if (contador.getNumeroContador().equals(numeroContador)) {
                return contador;
            }
        }
        return null;
    }

    /**
     * Obtiene una copia de la lista de contadores.
     * @return Lista de contadores.
     */
    public List<InformacionContadores> getListaContadores() {
        return new ArrayList<>(listaContadores);
    }

    /**
     * Reemplaza la lista actual de contadores.
     * @param listaContadores Nueva lista de contadores.
     */
    public void setListaContadores(List<InformacionContadores> listaContadores) {
        this.listaContadores = new ArrayList<>(listaContadores);
    }

    /**
     * Elimina un contador por su número (no implementado).
     * @param numero Número del contador a eliminar.
     * @return true si se elimina, false en caso contrario.
     */
    public boolean eliminarContador(String numero) {
        throw new UnsupportedOperationException("'eliminarContador'");
    }

    // Método que simula y registra consumos aleatorios por hora en un mes para todos los contadores
    public void cargarConsumoAleatorio(int año, int mes) {
        Random random = new Random();
        
        // Itera sobre cada contador registrado
        for (InformacionContadores contador : listaContadores) {
            //Aqui simula 30 dias
            for (int dia = 1; dia <= 30; dia++) {
                //aqui las 24 horas
                for (int hora = 0; hora < 24; hora++) {

                     // Formato de clave: YYYY-MM-DD-HH
                    String clave = String.format("%04d-%02d-%02d-%02d", año, mes, dia, hora);
                    // Genera consumo aleatorio entre 0.1 y 5.0 kWh (kilo, vatio (Watt),hora )
                    double consumo = 0.1 + (5.0 - 0.1) * random.nextDouble();
                    // Registra el consumo en el historial del contador
                    contador.getHistorial().registrarConsumo(clave, consumo);
                }
            }
        }
    }

    // Modifica el consumo registrado en una hora específica para un contador identificado por su ID
    public boolean modificarConsumo(String idContador, String fechaHora, double nuevoConsumo) {
        // Busca el contador correspondiente
        for (InformacionContadores contador : listaContadores) {
            if (contador.getId().equals(idContador)) {

                // Modifica el consumo en la fecha-hora especificada
                contador.getHistorial().modificarConsumo(fechaHora, nuevoConsumo);
                return true;
            }
        }
        // Si no se encontró el contador, devuelve false
        return false;
    }
    
}