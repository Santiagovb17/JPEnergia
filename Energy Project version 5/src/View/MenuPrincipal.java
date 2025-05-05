package View;

import Controller.ClientesControlador;
import Controller.ContadoresControlador;
import Controller.ConsumoControlador;
import java.util.Scanner;

public class MenuPrincipal {
    public static void iniciar(ClientesControlador clientesControlador,
                               ContadoresControlador contadoresControlador,
                               ConsumoControlador consumoControlador) {
        Scanner scanner = new Scanner(System.in);
        ConsolaClientes consolaClientes = new ConsolaClientes(clientesControlador, scanner);
        ConsolaContadores consolaContadores = new ConsolaContadores(contadoresControlador, scanner);
        ConsolaConsumos consolaConsumos = new ConsolaConsumos(consumoControlador, scanner);

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Contadores");
            System.out.println("3. Gestión de Consumos");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> consolaClientes.mostrarMenu();
                case 2 -> consolaContadores.mostrarMenu();
                case 3 -> consolaConsumos.mostrarMenu();
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
