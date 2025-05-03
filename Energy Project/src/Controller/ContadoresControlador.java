package Controller;

import Model.InformacionContadores;
import java.util.ArrayList;
import java.util.List;

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
}