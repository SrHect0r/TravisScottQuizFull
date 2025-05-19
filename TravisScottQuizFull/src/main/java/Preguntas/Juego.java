package Preguntas;

import Introducion.NombreUsuario;
import javax.swing.*;

public class  Juego {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Travis Scott Quiz");
            frame.setContentPane(new NombreUsuario(frame).getRootPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setVisible(true);
        });
    }
}
