package Controller;

import Model.InformacionClientes;
import java.util.ArrayList;
import java.util.List;

public class ClientesControlador {
    private List<InformacionClientes> listaClientes;

    /**
     * Constructor que inicializa el controlador con una lista de clientes.
     * @param listaClientes Lista inicial de clientes.
     */
    public ClientesControlador(List<InformacionClientes> listaClientes) {
        this.listaClientes = new ArrayList<>(listaClientes);
    }

    /**
     * Agrega un cliente a la lista.
     * @param cliente Cliente a agregar.
     */
    public void agregarCliente(InformacionClientes cliente) {
        listaClientes.add(cliente);
    }

    /**
     * Elimina un cliente de la lista.
     * @param cliente Cliente a eliminar.
     */
    public void eliminarCliente(InformacionClientes cliente) {
        listaClientes.remove(cliente);
    }

    /**
     * Modifica un cliente existente en la lista.
     * @param cliente Cliente con la información actualizada.
     */
    public void modificarCliente(InformacionClientes cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroIdentificacion().equals(cliente.getNumeroIdentificacion())) {
                listaClientes.set(i, cliente);
                break;
            }
        }
    }

    /**
     * Busca un cliente por su número de identificación.
     * @param numeroIdentificacion Número de identificación del cliente a buscar.
     * @return El cliente encontrado o null si no existe.
     */
    public InformacionClientes buscarCliente(String numeroIdentificacion) {
        for (InformacionClientes cliente : listaClientes) {
            if (cliente.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Obtiene una copia de la lista de clientes.
     * @return Lista de clientes.
     */
    public List<InformacionClientes> getListaClientes() {
        return new ArrayList<>(listaClientes);
    }

    /**
     * Reemplaza la lista actual de clientes.
     * @param listaClientes Nueva lista de clientes.
     */
    public void setListaClientes(List<InformacionClientes> listaClientes) {
        this.listaClientes = new ArrayList<>(listaClientes);
    }
}