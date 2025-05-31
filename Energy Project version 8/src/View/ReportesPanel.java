package View;

import Controller.ConsumoControlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class ReportesPanel extends JPanel {
    
    private ConsumoControlador controlador;
    private JTextField txtMes, txtCliente;
    private JTextArea txtResultados;
    
    public ReportesPanel(ConsumoControlador controlador) {
        this.controlador = controlador;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));
        panelEntrada.add(new JLabel("Mes:"));
        txtMes = new JTextField();
        panelEntrada.add(txtMes);
        panelEntrada.add(new JLabel("ID Cliente:"));
        txtCliente = new JTextField();
        panelEntrada.add(txtCliente);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 10, 10));
        String[] opciones = {"Franjas Horarias", "Consumo por Días", "Mínimo", "Máximo", "Generar Factura"};
        for (String opcion : opciones) {
            JButton btn = new JButton(opcion);
            btn.addActionListener(this::generarReporte);
            panelBotones.add(btn);
        }
        
        // Área de resultados
        txtResultados = new JTextArea(10, 50);
        txtResultados.setEditable(false);
        
        // Organización
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelEntrada, BorderLayout.NORTH);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(txtResultados), BorderLayout.CENTER);
    }
    
    private void generarReporte(ActionEvent e) {
        String mes = txtMes.getText();
        String clienteId = txtCliente.getText();
        String comando = ((JButton)e.getSource()).getText();
        
        if (clienteId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID del cliente es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String resultado = "";
            switch (comando) {
                case "Franjas Horarias":
                    Map<String, Double> franjas = controlador.obtenerConsumoPorFranja(clienteId);
                    resultado = "Consumo por franjas:\n";
                    for (Map.Entry<String, Double> entry : franjas.entrySet()) {
                        resultado += String.format("%s: %.2f kWh\n", entry.getKey(), entry.getValue());
                    }
                    break;
                    
                case "Generar Factura":
                    if (mes.isEmpty()) throw new IllegalArgumentException("Ingrese el mes");
                    double total = controlador.calcularValorFactura(mes, clienteId);
                    resultado = String.format("FACTURA\nCliente: %s\nMes: %s\nTotal: $%,.2f", 
                                            clienteId, mes, total);
                    break;
                    
                // Implementar otros casos...
            }
            txtResultados.setText(resultado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}