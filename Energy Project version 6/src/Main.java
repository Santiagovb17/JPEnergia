import Controller.ClientesControlador;
import Controller.ContadoresControlador;
import Controller.ConsumoControlador;
import Model.ConsumoEnergia;
import View.MenuPrincipal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClientesControlador clientesControlador = new ClientesControlador(new ArrayList<>());
        ContadoresControlador contadoresControlador = new ContadoresControlador(new ArrayList<>());
        ConsumoControlador consumoControlador = new ConsumoControlador(new ArrayList<>());

        // Ejemplo de consumo
        consumoControlador.agregarConsumo("Enero",
            new ConsumoEnergia("Enero", "12", 5, 250, "123456789", "CNT001"));

        System.out.println("=== SISTEMA DE GESTIÓN DE ENERGÍA ===");
        MenuPrincipal.iniciar(clientesControlador, contadoresControlador, consumoControlador);
        System.out.println("Aplicación finalizada");
    }
}
