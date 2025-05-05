package View;

import Controller.ContadoresControlador;
import Model.InformacionContadores;
import java.util.Scanner;

public class ConsolaContadores {
    private ContadoresControlador controlador; // Controlador para gestionar contadores
    private Scanner scanner; // Scanner para capturar la entrada del usuario

    /**
     * Constructor para inicializar la consola de contadores.
     * @param controlador Controlador de contadores.
     * @param scanner Scanner para capturar la entrada del usuario.
     */
    public ConsolaContadores(ContadoresControlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    /**
     * Muestra el menú principal de gestión de contadores.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ CONTADORES ===");
            System.out.println("1. Agregar Contador");
            System.out.println("2. Buscar Contador");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> buscar();
                case 3 -> System.out.println("Saliendo del menú de contadores...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    /**
     * Agrega un nuevo contador al sistema.
     */
    private void agregar() {
        System.out.println("Número de Contador:");
        String numeroContador = scanner.nextLine();
        System.out.println("Dirección del Contador:");
        String direccion = scanner.nextLine();
        System.out.println("Ciudad del Contador:");
        String ciudad = scanner.nextLine();
        controlador.agregarContador(new InformacionContadores(numeroContador, direccion, ciudad));
        System.out.println("Contador agregado exitosamente.");
    }

    /**
     * Busca un contador por su número.
     */
    private void buscar() {
        System.out.println("Número de Contador a buscar:");
        String numeroContador = scanner.nextLine();
        InformacionContadores contador = controlador.buscarContador(numeroContador);
        if (contador != null) {
            System.out.println("Contador encontrado: " + contador.getNumeroContador() +
                               ", Dirección: " + contador.getDireccion() +
                               ", Ciudad: " + contador.getCiudad());
        } else {
            System.out.println("Contador no encontrado.");
        }
    }
}