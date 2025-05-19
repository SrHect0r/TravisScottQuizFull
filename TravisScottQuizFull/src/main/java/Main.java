
import model.QuestionFactory;
import model.AbstractQuestion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AbstractQuestion> questions = QuestionFactory.loadQuestions("resources/preguntas.txt");

        // Imprimir todas las preguntas para verificar que se cargaron correctamente
        for (AbstractQuestion question : questions) {
            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(" - " + option);
            }
            System.out.println("Índice correcto: " + question.isCorrectAnswer(1));
            System.out.println(); // Línea en blanco entre preguntas
        }
    }
}

