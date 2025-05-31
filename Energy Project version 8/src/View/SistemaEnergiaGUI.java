package View;

import Controller.*;
import javax.swing.*;

public class SistemaEnergiaGUI extends JFrame {
    
    public SistemaEnergiaGUI(ClientesControlador cClientes, 
                           ContadoresControlador cContadores,
                           ConsumoControlador cConsumo) {
        setTitle("Sistema de Gestión de Energía");
        setSize(900, 650);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Clientes", new ClientesPanel(cClientes));
        tabbedPane.addTab("Contadores", new ContadoresPanel(cContadores));
        tabbedPane.addTab("Consumos", new ConsumosPanel(cConsumo));
        tabbedPane.addTab("Reportes", new ReportesPanel(cConsumo));

        add(tabbedPane);
    }
    
    public static void iniciar(ClientesControlador c1, 
                             ContadoresControlador c2, 
                             ConsumoControlador c3) {
        SwingUtilities.invokeLater(() -> {
            new SistemaEnergiaGUI(c1, c2, c3).setVisible(true);
        });
    }
}