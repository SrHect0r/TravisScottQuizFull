package MenuCategorias;

import 
import javax.swing.*;

public class Categorias {
    private JPanel rootPanel;
    private JButton albumesButton;
    private JButton colaboracionesButton;
    private JButton vidaButton;
    private JButton cancionesButton;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public Categorias(JFrame frame, String nombreJugador) {
        albumesButton.addActionListener(e -> abrirJuego(frame, "albumes", nombreJugador));
        colaboracionesButton.addActionListener(e -> abrirJuego(frame, "colaboraciones", nombreJugador));
        vidaButton.addActionListener(e -> abrirJuego(frame, "vida", nombreJugador));
        cancionesButton.addActionListener(e -> abrirJuego(frame, "canciones", nombreJugador));
    }

    private void abrirJuego(JFrame frame, String categoria, String nombreJugador) {
        frame.setContentPane(new JuegoPreguntas(frame, nombreJugador, categoria).getRootPanel());
        frame.revalidate();
    }
}
