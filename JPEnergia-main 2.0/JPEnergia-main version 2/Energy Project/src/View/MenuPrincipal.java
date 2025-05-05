package View;

import Controller.ClientesControlador;
import Controller.ContadoresControlador;
import java.util.Scanner;

public class MenuPrincipal {

    /**
     * Inicia el menú principal de la aplicación.
     * @param clientesControlador Controlador para gestionar clientes.
     * @param contadoresControlador Controlador para gestionar contadores.
     */
    public static void iniciar(ClientesControlador clientesControlador, ContadoresControlador contadoresControlador) {
        Scanner scanner = new Scanner(System.in);
        ConsolaClientes consolaClientes = new ConsolaClientes(clientesControlador, scanner);
        ConsolaContadores consolaContadores = new ConsolaContadores(contadoresControlador, scanner);
        
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Contadores");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> consolaClientes.mostrarMenu(); // Muestra el menú de clientes
                case 2 -> consolaContadores.mostrarMenu(); // Muestra el menú de contadores
                case 3 -> System.out.println("Saliendo del programa..."); // Finaliza el programa
                default -> System.out.println("Opción no válida. Intente nuevamente."); // Manejo de opción inválida
            }
        } while (opcion != 3);

        scanner.close(); // Cierra el scanner al finalizar
    }
}