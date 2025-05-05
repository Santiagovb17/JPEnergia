package View;

import Controller.ClientesControlador;
import Model.InformacionClientes;
import java.util.Scanner;

public class ConsolaClientes {
    private ClientesControlador controlador; // Controlador para gestionar clientes
    private Scanner scanner; // Scanner para capturar la entrada del usuario

    /**
     * Constructor para inicializar la consola de clientes.
     * @param controlador Controlador de clientes.
     * @param scanner Scanner para capturar la entrada del usuario.
     */
    public ConsolaClientes(ClientesControlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    /**
     * Muestra el menú principal de gestión de clientes.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ CLIENTES ===");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> buscar();
                case 3 -> System.out.println("Saliendo del menú de clientes...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    /**
     * Agrega un nuevo cliente al sistema.
     */
    private void agregar() {
        System.out.println("Número de Identificación:");
        String numeroIdentificacion = scanner.nextLine();
        System.out.println("Tipo de Identificación:");
        String tipoIdentificacion = scanner.nextLine();
        controlador.agregarCliente(new InformacionClientes(numeroIdentificacion, tipoIdentificacion, "", ""));
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * Busca un cliente por su número de identificación.
     */
    private void buscar() {
        System.out.println("Número de Identificación a buscar:");
        String numeroIdentificacion = scanner.nextLine();
        InformacionClientes cliente = controlador.buscarCliente(numeroIdentificacion);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNumeroIdentificacion());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}