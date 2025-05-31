package View;

import Controller.ContadoresControlador;
import Model.InformacionContadores;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ContadoresPanel extends JPanel {
    private ContadoresControlador controlador;
    
    // Componentes de UI
    private JTextField txtNumero, txtDireccion, txtCiudad;
    private JButton btnGuardar, btnBuscar, btnEliminar;
    private JTextArea txtResultados;
    private JComboBox<String> cmbContadores;

    public ContadoresPanel(ContadoresControlador controlador) {
        this.controlador = controlador;
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        // Campos de texto
        txtNumero = new JTextField(15);
        txtDireccion = new JTextField(15);
        txtCiudad = new JTextField(15);
        
        // Botones
        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");
        
        // Área de resultados
        txtResultados = new JTextArea(10, 30);
        txtResultados.setEditable(false);
        
        // ComboBox para selección
        cmbContadores = new JComboBox<>();
        actualizarListaContadores();
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Número Contador
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Número Contador:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtNumero, gbc);

        // Dirección
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtDireccion, gbc);

        // Ciudad
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Ciudad:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtCiudad, gbc);

        // Botones
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnEliminar);
        formPanel.add(buttonPanel, gbc);

        // Panel de selección
        JPanel selectionPanel = new JPanel(new BorderLayout(10, 10));
        selectionPanel.add(new JLabel("Contadores Registrados:"), BorderLayout.NORTH);
        selectionPanel.add(new JScrollPane(cmbContadores), BorderLayout.CENTER);

        // Panel principal izquierdo
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.add(formPanel, BorderLayout.NORTH);
        leftPanel.add(selectionPanel, BorderLayout.CENTER);

        // Panel de resultados
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JScrollPane(txtResultados), BorderLayout.CENTER);

        // Organización final
        add(leftPanel, BorderLayout.WEST);
        add(resultPanel, BorderLayout.CENTER);
    }

    private void setupListeners() {
        btnGuardar.addActionListener(this::guardarContador);
        btnBuscar.addActionListener(this::buscarContador);
        btnEliminar.addActionListener(this::eliminarContador);
        cmbContadores.addActionListener(e -> cargarDatosContador());
    }

    private void guardarContador(ActionEvent e) {
        try {
            InformacionContadores contador = new InformacionContadores(
                txtNumero.getText(),
                txtDireccion.getText(),
                txtCiudad.getText()
            );

            if (controlador.buscarContador(contador.getNumeroContador()) != null) {
                controlador.modificarContador(contador);
                txtResultados.setText("Contador actualizado exitosamente");
            } else {
                controlador.agregarContador(contador);
                txtResultados.setText("Contador registrado exitosamente");
            }

            actualizarListaContadores();
            limpiarCampos();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarContador(ActionEvent e) {
        String numero = txtNumero.getText();
        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de contador", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        InformacionContadores contador = controlador.buscarContador(numero);
        if (contador != null) {
            txtDireccion.setText(contador.getDireccion());
            txtCiudad.setText(contador.getCiudad());
            txtResultados.setText("Contador encontrado:\n" + contador.toString());
        } else {
            txtResultados.setText("No se encontró el contador");
        }
    }

    private void eliminarContador(ActionEvent e) {
        String numero = txtNumero.getText();
        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de contador", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        InformacionContadores contador = controlador.buscarContador(numero);
        if (contador != null) {
            controlador.eliminarContador(contador);
            txtResultados.setText("Contador eliminado: " + numero);
            actualizarListaContadores();
            limpiarCampos();
        } else {
            txtResultados.setText("No se encontró el contador");
        }
    }

    private void cargarDatosContador() {
        String seleccionado = (String) cmbContadores.getSelectedItem();
        if (seleccionado != null && !seleccionado.isEmpty()) {
            InformacionContadores contador = controlador.buscarContador(seleccionado);
            if (contador != null) {
                txtNumero.setText(contador.getNumeroContador());
                txtDireccion.setText(contador.getDireccion());
                txtCiudad.setText(contador.getCiudad());
            }
        }
    }

    private void actualizarListaContadores() {
        cmbContadores.removeAllItems();
        controlador.getListaContadores().forEach(c -> 
            cmbContadores.addItem(c.getNumeroContador())
        );
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
    }
}