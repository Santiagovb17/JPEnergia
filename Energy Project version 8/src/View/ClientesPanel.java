package View;

import Controller.ClientesControlador;
import Model.InformacionClientes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClientesPanel extends JPanel {

    private ClientesControlador controlador;
    private JTextField txtNumero, txtTipo, txtCorreo, txtDireccion;

    public ClientesPanel(ClientesControlador controlador) {
        this.controlador = controlador;
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        int fieldWidth = 18; // Más largo horizontalmente
        Dimension fieldSize = new Dimension(200, 26);

        // Número Identificación
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Número Identificación:"), gbc);
        gbc.gridx = 1;
        txtNumero = new JTextField(fieldWidth);
        txtNumero.setPreferredSize(fieldSize);
        add(txtNumero, gbc);

        // Tipo Identificación
        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Tipo Identificación:"), gbc);
        gbc.gridx = 1;
        txtTipo = new JTextField(fieldWidth);
        txtTipo.setPreferredSize(fieldSize);
        add(txtTipo, gbc);

        // Correo Electrónico
        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Correo Electrónico:"), gbc);
        gbc.gridx = 1;
        txtCorreo = new JTextField(fieldWidth);
        txtCorreo.setPreferredSize(fieldSize);
        add(txtCorreo, gbc);

        // Dirección Física
        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Dirección Física:"), gbc);
        gbc.gridx = 1;
        txtDireccion = new JTextField(fieldWidth);
        txtDireccion.setPreferredSize(fieldSize);
        add(txtDireccion, gbc);

        // Botón Guardar
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnGuardar = new JButton("Guardar Cliente");
        btnGuardar.addActionListener(this::guardarCliente);
        add(btnGuardar, gbc);
    }

    private void guardarCliente(ActionEvent e) {
        try {
            InformacionClientes cliente = new InformacionClientes(
                txtNumero.getText(),
                txtTipo.getText(),
                txtCorreo.getText(),
                txtDireccion.getText()
            );
            controlador.agregarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente registrado!");
            limpiarCampos();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtTipo.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
    }
}