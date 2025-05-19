package Preguntas;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Juego {
    private JPanel rootPanel;
    private JLabel preguntaLabel;
    private JButton respuesta1Button;
    private JButton respuesta2Button;
    private JButton respuesta3Button;
    private JButton respuesta4Button;
    private JLabel vidasLabel;
    private JLabel tiempoLabel;

    private int vidas = 3;
    private int tiempo = 30;
    private Timer timer;

    private final List<String[]> preguntas;
    private int indicePregunta = 0;
    private String[] preguntaActual;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public Juego(JFrame frame, String nombreUsuario, String categoria) {
        iniciarTemporizador(frame);

        Map<String, List<String[]>> preguntasPorCategoria = LectorPreguntas.cargarPreguntas();
        preguntas = preguntasPorCategoria.getOrDefault(categoria.toLowerCase(), new ArrayList<>());
        Collections.shuffle(preguntas);

        if (preguntas.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay preguntas disponibles para esta categoría.");
            frame.dispose();
            return;
        }

        mostrarSiguientePregunta();

        respuesta1Button.addActionListener(e -> verificarRespuesta(frame, respuesta1Button.getText()));
        respuesta2Button.addActionListener(e -> verificarRespuesta(frame, respuesta2Button.getText()));
        respuesta3Button.addActionListener(e -> verificarRespuesta(frame, respuesta3Button.getText()));
        respuesta4Button.addActionListener(e -> verificarRespuesta(frame, respuesta4Button.getText()));
    }

    private void iniciarTemporizador(JFrame frame) {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tiempo--;
                tiempoLabel.setText("Tiempo: " + tiempo + "s");
                if (tiempo == 0) {
                    timer.stop();
                    perderVida(frame);
                }
            }
        });
        timer.start();
    }

    private void mostrarSiguientePregunta() {
        if (indicePregunta >= preguntas.size()) {
            JOptionPane.showMessageDialog(rootPanel, "¡Has completado todas las preguntas!");
            return;
        }

        preguntaActual = preguntas.get(indicePregunta++);
        preguntaLabel.setText(preguntaActual[0]); // La pregunta

        List<String> opciones = Arrays.asList(
                preguntaActual[1], // Opción 1
                preguntaActual[2], // Opción 2
                preguntaActual[3], // Opción 3
                preguntaActual[4]  // Opción 4
        );
        Collections.shuffle(opciones);

        respuesta1Button.setText(opciones.get(0));
        respuesta2Button.setText(opciones.get(1));
        respuesta3Button.setText(opciones.get(2));
        respuesta4Button.setText(opciones.get(3));

        vidasLabel.setText("Vidas: " + vidas);
        tiempoLabel.setText("Tiempo: " + tiempo);
    }

    private void verificarRespuesta(JFrame frame, String respuestaSeleccionada) {
        if (preguntaActual == null) {
            JOptionPane.showMessageDialog(frame, "Error: no hay pregunta actual.");
            return;
        }

        String respuestaCorrecta = preguntaActual[5]; // Respuesta correcta en la posición 5

        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            JOptionPane.showMessageDialog(rootPanel, "¡Correcto!");
            tiempo = 30;
            mostrarSiguientePregunta();
        } else {
            perderVida(frame);
        }
    }

    private void perderVida(JFrame frame) {
        vidas--;
        if (vidas <= 0) {
            timer.stop();
            JOptionPane.showMessageDialog(frame, "Se acabaron tus vidas.");
            frame.dispose();
        } else {
            tiempo = 30;
            vidasLabel.setText("Vidas: " + vidas);
            mostrarSiguientePregunta();
        }
    }
}
