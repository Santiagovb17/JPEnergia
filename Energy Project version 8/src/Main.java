import Controller.*;
import Model.ConsumoEnergia;
import View.MenuPrincipal;
import View.SistemaEnergiaGUI;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*; // Importar Swing para UIManager
import java.awt.*; // Importar AWT para Color

public class Main {
    public static void main(String[] args) {
        // Colores claros y modernos
        UIManager.put("Panel.background", new Color(245, 248, 250));         // Gris muy claro
        UIManager.put("Label.foreground", new Color(60, 60, 60));            // Gris oscuro
        UIManager.put("Button.background", new Color(173, 216, 230));        // Celeste claro
        UIManager.put("Button.foreground", new Color(40, 40, 40));           // Gris oscuro
        UIManager.put("TextField.background", new Color(255, 255, 255));     // Blanco
        UIManager.put("TextField.foreground", new Color(60, 60, 60));        // Gris oscuro
        UIManager.put("TabbedPane.selected", new Color(200, 230, 255));      // Azul muy claro para pestaña activa

        // Inicialización estándar
        ClientesControlador clientesCtrl = new ClientesControlador(new ArrayList<>());
        ContadoresControlador contadoresCtrl = new ContadoresControlador(new ArrayList<>());
        ConsumoControlador consumoCtrl = new ConsumoControlador(new ArrayList<>());
        
        // Datos de ejemplo
        consumoCtrl.agregarConsumo("Enero", 
            new ConsumoEnergia("Enero", "15", 10, 150, "1001", "CNT001"));

        try (// Permitir al usuario elegir la interfaz
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("Seleccione la interfaz:");
            System.out.println("1. Gráfica (GUI)");
            System.out.println("2. Consola");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                SistemaEnergiaGUI.iniciar(clientesCtrl, contadoresCtrl, consumoCtrl);
            } else {
                MenuPrincipal.iniciar(clientesCtrl, contadoresCtrl, consumoCtrl);
            }
        }
    }
}
