package PrimerParcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import PrimerParcial.Niño; 

public class NiñoRegistroGUI extends JFrame {
    private ArrayList<Niño> niñosRegistrados;
    private JTextField txtDni, txtNombres, txtApellidos, txtEdad, txtTelefono;
    private JComboBox<String> comboRefrigerio, comboBebida;
    private JTextArea areaResultados;
    private int numeroRifa = 1;

    public NiñoRegistroGUI() {
        niñosRegistrados = new ArrayList<>();
        
       
        setTitle("Registro Día del Niño");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

      
        JPanel panelEntrada = new JPanel(new GridLayout(7, 2));
        panelEntrada.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panelEntrada.add(txtDni);
        
        panelEntrada.add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        panelEntrada.add(txtNombres);
        
        panelEntrada.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelEntrada.add(txtApellidos);
        
        panelEntrada.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelEntrada.add(txtEdad);
        
        panelEntrada.add(new JLabel("Teléfono del Padre:"));
        txtTelefono = new JTextField();
        panelEntrada.add(txtTelefono);
        
        panelEntrada.add(new JLabel("Refrigerio:"));
        comboRefrigerio = new JComboBox<>(new String[]{"Perro Caliente", "Hamburguesa", "Papitas McDonald's"});
        panelEntrada.add(comboRefrigerio);
        
        panelEntrada.add(new JLabel("Bebida:"));
        comboBebida = new JComboBox<>(new String[]{"Gaseosa", "Agua"});
        panelEntrada.add(comboBebida);

    
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar Niño");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarNiño();
            }
        });
        panelBotones.add(btnRegistrar);
        
      
        areaResultados = new JTextArea(10, 30);
        JScrollPane scroll = new JScrollPane(areaResultados);
        areaResultados.setEditable(false);

       
        add(panelEntrada, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

      
        setVisible(true);
    }

   
    private void registrarNiño() {
        try {
            String dni = txtDni.getText();
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String telefonoPadre = txtTelefono.getText();
            String refrigerio = (String) comboRefrigerio.getSelectedItem();
            String bebida = (String) comboBebida.getSelectedItem();

          
            if (edad > 13) {
                JOptionPane.showMessageDialog(this, "No cumple con la edad permitida para el evento.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        
            Niño niño = new Niño(dni, nombres, apellidos, edad, telefonoPadre);
            niño.setRefrigerio(refrigerio);
            niño.setBebida(bebida);
            niño.setNumeroRifa(numeroRifa++);
            niñosRegistrados.add(niño);

          
            areaResultados.append("Niño Registrado:\n" + niño.toString() + "\n\n");

            
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    private void limpiarCampos() {
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        comboRefrigerio.setSelectedIndex(0);
        comboBebida.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new NiñoRegistroGUI();
    }
}
