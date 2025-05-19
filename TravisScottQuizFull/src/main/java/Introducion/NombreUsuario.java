package Introducion;

import MenuCategorias.Categorias;

import javax.swing.*;

public class NombreUsuario {
    private JPanel rootPanel;
    private JTextField nameTextField;
    private JButton continuarButton;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public NombreUsuario(JFrame frame) {
        continuarButton.addActionListener(e -> {
            String nombre = nameTextField.getText().trim();
            if (!nombre.isEmpty()) {
                frame.setContentPane(new Categorias(frame, nombre).getRootPanel());
                frame.revalidate();
            } else {
                JOptionPane.showMessageDialog(frame, "Por favor, ingresa tu nombre");
            }
        });
    }
}

