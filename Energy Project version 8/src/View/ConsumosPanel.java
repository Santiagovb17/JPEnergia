package View;

import Controller.ConsumoControlador;
import Model.ConsumoEnergia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConsumosPanel extends JPanel {
    private ConsumoControlador controlador;
    
    // Componentes de UI
    private JTextField txtMes, txtDia, txtHora, txtKwh, txtCliente, txtContador;
    private JButton btnGuardar, btnModificar, btnBuscar;
    private JTextArea txtResultados;
    private JComboBox<String> cmbMeses;

    public ConsumosPanel(ConsumoControlador controlador) {
        this.controlador = controlador;
        initComponents();
        setupLayout();
        setupListeners();
        cargarMeses();
    }

    private void initComponents() {
        // Campos de texto
        txtMes = new JTextField(10);
        txtDia = new JTextField(10);
        txtHora = new JTextField(10);
        txtKwh = new JTextField(10);
        txtCliente = new JTextField(10);
        txtContador = new JTextField(10);
        
        // Botones
        btnGuardar = new JButton("Guardar Consumo");
        btnModificar = new JButton("Modificar Consumo");
        btnBuscar = new JButton("Buscar Consumos");
        
        // Área de resultados
        txtResultados = new JTextArea(15, 40);
        txtResultados.setEditable(false);
        
        // ComboBox para meses
        cmbMeses = new JComboBox<>();
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Fila 1
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Mes:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtMes, gbc);
        gbc.gridx = 2;
        formPanel.add(new JLabel("Día:"), gbc);
        gbc.gridx = 3;
        formPanel.add(txtDia, gbc);

        // Fila 2
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Hora (0-23):"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtHora, gbc);
        gbc.gridx = 2;
        formPanel.add(new JLabel("kWh:"), gbc);
        gbc.gridx = 3;
        formPanel.add(txtKwh, gbc);

        // Fila 3
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("ID Cliente:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtCliente, gbc);
        gbc.gridx = 2;
        formPanel.add(new JLabel("N° Contador:"), gbc);
        gbc.gridx = 3;
        formPanel.add(txtContador, gbc);

        // Botones
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnBuscar);
        formPanel.add(buttonPanel, gbc);

        // Panel de búsqueda por mes
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Ver consumos de:"));
        searchPanel.add(cmbMeses);
        
        // Panel principal izquierdo
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.add(formPanel, BorderLayout.NORTH);
        leftPanel.add(searchPanel, BorderLayout.CENTER);

        // Panel de resultados
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JScrollPane(txtResultados), BorderLayout.CENTER);

        // Organización final
        add(leftPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
    }

    private void setupListeners() {
        btnGuardar.addActionListener(this::guardarConsumo);
        btnModificar.addActionListener(this::modificarConsumo);
        btnBuscar.addActionListener(this::buscarConsumos);
        cmbMeses.addActionListener(e -> mostrarConsumosPorMes());
    }

    private void cargarMeses() {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                         "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (String mes : meses) {
            cmbMeses.addItem(mes);
        }
    }

    private void guardarConsumo(ActionEvent e) {
        try {
            ConsumoEnergia consumo = crearConsumoDesdeCampos();
            controlador.agregarConsumo(consumo.getMes(), consumo);
            txtResultados.setText("Consumo registrado:\n" + consumo.toString());
            limpiarCampos();
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarConsumo(ActionEvent e) {
        try {
            ConsumoEnergia consumo = crearConsumoDesdeCampos();
            boolean modificado = controlador.modificarConsumo(
                consumo.getMes(),
                consumo.getDia(),
                consumo.getHora(),
                consumo.getNumeroContador(),
                consumo.getNumeroIdentificacionCliente(),
                consumo.getKwh()
            );
            
            if (modificado) {
                txtResultados.setText("Consumo modificado exitosamente");
            } else {
                txtResultados.setText("No se encontró el consumo a modificar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarConsumos(ActionEvent e) {
        String mes = txtMes.getText();
        if (!mes.isEmpty()) {
            mostrarConsumosPorMes(mes);
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un mes para buscar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarConsumosPorMes() {
        String mes = (String) cmbMeses.getSelectedItem();
        mostrarConsumosPorMes(mes);
    }

    private void mostrarConsumosPorMes(String mes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Consumos registrados en ").append(mes).append(":\n\n");
        
        controlador.obtenerConsumosPorMes(mes).forEach(consumo -> 
            sb.append(consumo.toString()).append("\n\n")
        );
        
        txtResultados.setText(sb.toString());
    }

    private ConsumoEnergia crearConsumoDesdeCampos() {
        validarCamposObligatorios();
        
        return new ConsumoEnergia(
            txtMes.getText(),
            txtDia.getText(),
            Integer.parseInt(txtHora.getText()),
            Double.parseDouble(txtKwh.getText()),
            txtCliente.getText(),
            txtContador.getText()
        );
    }

    private void validarCamposObligatorios() {
        if (txtMes.getText().isEmpty() || txtDia.getText().isEmpty() || 
            txtHora.getText().isEmpty() || txtKwh.getText().isEmpty() || 
            txtCliente.getText().isEmpty() || txtContador.getText().isEmpty()) {
            throw new IllegalStateException("Todos los campos son obligatorios");
        }
        
        int hora = Integer.parseInt(txtHora.getText());
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("La hora debe estar entre 0 y 23");
        }
        
        double kwh = Double.parseDouble(txtKwh.getText());
        if (kwh < 0) {
            throw new IllegalArgumentException("El consumo no puede ser negativo");
        }
    }

    private void limpiarCampos() {
        txtMes.setText("");
        txtDia.setText("");
        txtHora.setText("");
        txtKwh.setText("");
        txtCliente.setText("");
        txtContador.setText("");
    }
}