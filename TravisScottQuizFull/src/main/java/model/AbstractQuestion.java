package model;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractQuestion {
    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public AbstractQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = Arrays.asList(options); // Convierte el arreglo a lista
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int index) {
        return index == correctAnswerIndex;
    }

    public String getCategory() {
        // Implementa según sea necesario
        return "Categoría"; // Ejemplo
    }
}
