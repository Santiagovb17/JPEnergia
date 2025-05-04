import Controller.ClientesControlador;
import Controller.ContadoresControlador;
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
        
        // Inicio de la aplicación
        System.out.println("=== SISTEMA DE GESTIÓN DE ENERGÍA ===");
        MenuPrincipal.iniciar(clientesControlador, contadoresControlador); // Llama al menú principal
        System.out.println("Aplicación finalizada"); // Mensaje al finalizar
    }
}