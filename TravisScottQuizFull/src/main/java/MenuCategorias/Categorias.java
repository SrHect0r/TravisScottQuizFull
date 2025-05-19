package MenuCategorias;

import Preguntas.Juego;

import javax.swing.*;

public class Categorias {
    private JPanel rootPanel;
    private JButton opcion1Button;
    private JButton opcion2Button;
    private JButton opcion3Button;
    private JButton opcion4Button;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public Categorias(JFrame frame, String nombreJugador) {
        opcion1Button.addActionListener(e -> iniciarJuego(frame, nombreJugador, "album"));
        opcion2Button.addActionListener(e -> iniciarJuego(frame, nombreJugador, "collab"));
        opcion3Button.addActionListener(e -> iniciarJuego(frame, nombreJugador, "vida"));
        opcion4Button.addActionListener(e -> iniciarJuego(frame, nombreJugador, "canciones"));
    }

    private void iniciarJuego(JFrame frame, String nombre, String categoria) {
        frame.setContentPane(new Juego (frame, nombre, categoria).getRootPanel());
        frame.revalidate();
    }
}
