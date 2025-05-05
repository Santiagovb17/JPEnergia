package View;

import Controller.ConsumoControlador;
import Model.ConsumoEnergia;
import java.util.Scanner;

public class ConsolaConsumos {
    private ConsumoControlador controlador;
    private Scanner scanner;

    public ConsolaConsumos(ConsumoControlador controlador, Scanner scanner) {
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ CONSUMOS ===");
            System.out.println("1. Agregar consumo");
            System.out.println("2. Ver consumos por mes");
            System.out.println("3. Modificar consumo");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> ver();
                case 3 -> modificar();
                case 4 -> System.out.println("Saliendo del menú de consumos...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void agregar() {
        System.out.print("Mes: ");
        String mes = scanner.nextLine();
        System.out.print("Día: ");
        String dia = scanner.nextLine();
        System.out.print("Hora (0-23): ");
        int hora = scanner.nextInt();
        System.out.print("kWh: ");
        double kwh = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer
        System.out.print("ID Cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("Número de Contador: ");
        String numeroContador = scanner.nextLine();

        ConsumoEnergia consumo = new ConsumoEnergia(mes, dia, hora, kwh, idCliente, numeroContador);
        controlador.agregarConsumo(mes, consumo);
        System.out.println("Consumo agregado correctamente.");
    }

    private void ver() {
        System.out.print("Mes a consultar: ");
        String mes = scanner.nextLine();
        controlador.mostrarConsumos(mes);
    }

    private void modificar() {
        System.out.print("Mes: ");
        String mes = scanner.nextLine();
        System.out.print("Día: ");
        String dia = scanner.nextLine();
        System.out.print("Hora: ");
        int hora = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo kWh: ");
        double nuevoKwh = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("ID Cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("Número Contador: ");
        String numContador = scanner.nextLine();

        boolean modificado = controlador.modificarConsumo(mes, dia, hora, idCliente, numContador, nuevoKwh);
        if (modificado) {
            System.out.println("Consumo modificado exitosamente.");
        } else {
            System.out.println("No se encontró el consumo para modificar.");
        }
    }
}
