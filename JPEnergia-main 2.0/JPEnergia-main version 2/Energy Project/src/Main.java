import Controller.ClientesControlador;
import Controller.ContadoresControlador;
import Controller.ConsumoControlador; // Importar el controlador de consumo
import Model.ConsumoEnergia; // Importar la clase ConsumoEnergia
import View.MenuPrincipal;
import java.util.ArrayList;

public class Main {

    /**
     * Método principal para iniciar la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicialización de controladores con listas vacías
        ClientesControlador clientesControlador = new ClientesControlador(new ArrayList<>()); // Controlador de clientes
        ContadoresControlador contadoresControlador = new ContadoresControlador(new ArrayList<>()); // Controlador de contadores
        ConsumoControlador consumoControlador = new ConsumoControlador(new ArrayList<>()); // Controlador de consumo
        
        // Agregar un consumo de ejemplo
        consumoControlador.agregarConsumo("Enero", 
            new ConsumoEnergia("Enero", "12", 5, 250, "123456789", "CNT001"));

        // Inicio de la aplicación
        System.out.println("=== SISTEMA DE GESTIÓN DE ENERGÍA ===");
        MenuPrincipal.iniciar(clientesControlador, contadoresControlador); // Llama al menú principal
        System.out.println("Aplicación finalizada"); // Mensaje al finalizar
    }
}