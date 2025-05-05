/**
 * Clase Main
 * Punto de entrada principal para el sistema de gestión de energía.
 * Inicializa los controladores y ejecuta el menú principal.
 */
import Controller.ClientesControlador;
import Controller.ConsumoControlador;
import Controller.ContadoresControlador;
import Model.ConsumoEnergia;
import View.MenuPrincipal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inicializa el controlador de clientes con una lista vacía
        ClientesControlador clientesControlador = new ClientesControlador(new ArrayList<>());

        // Inicializa el controlador de contadores con una lista vacía
        ContadoresControlador contadoresControlador = new ContadoresControlador(new ArrayList<>());

        // Inicializa el controlador de consumos con una lista vacía
        ConsumoControlador consumoControlador = new ConsumoControlador(new ArrayList<>());

        // Agrega un ejemplo de consumo de energía al controlador de consumos
        consumoControlador.agregarConsumo("Enero",
            new ConsumoEnergia("Enero", "12", 5, 250, "123456789", "CNT001"));

        // Muestra un mensaje inicial
        System.out.println("=== SISTEMA DE GESTIÓN DE ENERGÍA ===");

        // Llama al menú principal para iniciar la interacción con el usuario
        MenuPrincipal.iniciar(clientesControlador, contadoresControlador, consumoControlador);

        // Muestra un mensaje final al cerrar la aplicación
        System.out.println("Aplicación finalizada");
    }
}
