package View;

import Controller.ConsumoControlador;
import Model.ConsumoEnergia;

import java.util.InputMismatchException;
import java.util.Map;
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
            mostrarOpcionesMenu();
            try {
                System.out.print("Seleccione opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> agregar();
                    case 2 -> ver();
                    case 3 -> modificar();
                    case 4 -> verConsumoPorFranjas();
                    case 5 -> verConsumoPorDias();
                    case 6 -> verConsumoMinimoMes();
                    case 7 -> verConsumoMaximoMes();
                    case 8 -> System.out.println("Saliendo del menú de consumos...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // limpiar buffer
                opcion = -1; // Reiniciar opción para continuar el bucle
            }
        } while (opcion != 8);
    }

    private void mostrarOpcionesMenu() {
        System.out.println("\n=== MENÚ CONSUMOS ===");
        System.out.println("1. Agregar consumo");
        System.out.println("2. Ver consumos por mes");
        System.out.println("3. Modificar consumo");
        System.out.println("4. Ver consumo por franjas horarias de un cliente");
        System.out.println("5. Ver consumo por días de un cliente");
        System.out.println("6. Ver consumo mínimo de un mes");
        System.out.println("7. Ver consumo máximo de un mes");
        System.out.println("8. Salir");
    }

    private void agregar() {
        try {
            System.out.print("Mes: ");
            String mes = scanner.nextLine();
            System.out.print("Día: ");
            String dia = scanner.nextLine();
            System.out.print("Hora (0-23): ");
            int hora = scanner.nextInt();
            if (hora < 0 || hora > 23) {
                System.out.println("La hora debe estar entre 0 y 23.");
                return;
            }
            System.out.print("kWh: ");
            double kwh = scanner.nextDouble();
            if (kwh < 0) {
                System.out.println("El consumo en kWh no puede ser negativo.");
                return;
            }
            scanner.nextLine(); // limpiar buffer
            System.out.print("ID Cliente: ");
            String idCliente = scanner.nextLine();
            System.out.print("Número de Contador: ");
            String numeroContador = scanner.nextLine();

            ConsumoEnergia consumo = new ConsumoEnergia(mes, dia, hora, kwh, idCliente, numeroContador);
            controlador.agregarConsumo(mes, consumo);
            System.out.println("Consumo agregado correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, intente de nuevo.");
            scanner.nextLine(); // limpiar buffer
        }
    }

    private void ver() {
        System.out.print("Mes a consultar: ");
        String mes = scanner.nextLine();
        controlador.mostrarConsumos(mes);
    }

    private void modificar() {
        try {
            System.out.print("Mes: ");
            String mes = scanner.nextLine();
            System.out.print("Día: ");
            String dia = scanner.nextLine();
            System.out.print("Hora: ");
            int hora = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nuevo kWh: ");
            double nuevoKwh = scanner.nextDouble();
            if (nuevoKwh < 0) {
                System.out.println("El consumo en kWh no puede ser negativo.");
                return;
            }
            scanner.nextLine();
            System.out.print("Ingrese Su Numero De Identificacion De Cliente: ");
            String idCliente = scanner.nextLine();
            System.out.print("Número Contador: ");
            String numContador = scanner.nextLine();

            boolean modificado = controlador.modificarConsumo(mes, dia, hora, idCliente, numContador, nuevoKwh);
            if (modificado) {
                System.out.println("Consumo modificado exitosamente.");
            } else {
                System.out.println("No se encontró el consumo para modificar.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, intente de nuevo.");
            scanner.nextLine(); // limpiar buffer
        }
    }

    private void verConsumoPorFranjas() {
        System.out.print("Ingrese Su Numero De Identificacion De Cliente: ");
        String idCliente = scanner.nextLine();
        Map<String, Double> consumos = controlador.obtenerConsumoPorFranja(idCliente);

        System.out.println("Consumo por franjas horarias:");
        for (Map.Entry<String, Double> entry : consumos.entrySet()) {
            System.out.printf("%s: %.2f kWh\n", entry.getKey(), entry.getValue());
        }
    }

    private void verConsumoPorDias() {
        System.out.print("Ingrese Su Numero De Identificacion De Cliente: ");
        String idCliente = scanner.nextLine();
        Map<String, Double> consumos = controlador.obtenerConsumoPorDia(idCliente);

        System.out.println("Consumo por días:");
        for (Map.Entry<String, Double> entry : consumos.entrySet()) {
            System.out.printf("Día %s: %.2f kWh\n", entry.getKey(), entry.getValue());
        }
    }

    private void verConsumoMinimoMes() {
        System.out.print("Mes a consultar: ");
        String mes = scanner.nextLine();
        System.out.print("Ingrese su número de identificación de cliente: ");
        String idCliente = scanner.nextLine();

        ConsumoEnergia minimo = controlador.obtenerConsumoMinimoPorMes(mes, idCliente);
        if (minimo != null) {
            System.out.println("Consumo mínimo del mes:");
            System.out.println(minimo);
        } else {
            System.out.println("No se encontraron consumos para el mes o cliente especificado.");
        }
    }

    private void verConsumoMaximoMes() {
        System.out.print("Mes a consultar: ");
        String mes = scanner.nextLine();
        System.out.print("Ingrese su número de identificación de cliente: ");
        String idCliente = scanner.nextLine();

        ConsumoEnergia maximo = controlador.obtenerConsumoMaximoPorMes(mes, idCliente);
        if (maximo != null) {
            System.out.println("Consumo máximo del mes:");
            System.out.println(maximo);
        } else {
            System.out.println("No se encontraron consumos para el mes o cliente especificado.");
        }
    }
}
