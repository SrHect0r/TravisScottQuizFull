package Preguntas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class LectorPreguntas {
    public static Map<String, List<String[]>> cargarPreguntas() {
        Map<String, List<String[]>> preguntas = new HashMap<>();

        try (InputStream is = LectorPreguntas.class.getClassLoader().getResourceAsStream("preguntas.txt")) {
            if (is == null) {
                System.out.println("No se encontró el archivo preguntas.txt");
                return preguntas;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.trim().split(";");
                if (datos.length == 7) {
                    String categoria = datos[0].toLowerCase();
                    String[] pregunta = {
                            datos[1], // Pregunta
                            datos[2], // Opción 1
                            datos[3], // Opción 2
                            datos[4], // Opción 3
                            datos[5], // Opción 4
                            datos[6]  // Respuesta correcta
                    };

                    preguntas.computeIfAbsent(categoria, k -> new ArrayList<>()).add(pregunta);
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo preguntas: " + e.getMessage());
        }

        // DEBUG: Mostrar las categorías cargadas
        System.out.println("Categorías cargadas: " + preguntas.keySet());

        return preguntas;
    }
}
