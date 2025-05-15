// --- Project 1: Online Quiz Application ---

import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean ask(Scanner scanner) {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer: ");
        int answer = scanner.nextInt();
        return answer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = Arrays.asList(
            new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 2),
            new Question("Which language runs in a web browser?", new String[]{"Java", "C", "Python", "JavaScript"}, 4)
        );

        int score = 0;
        for (Question q : questions) {
            if (q.ask(scanner)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong.\n");
            }
        }
        System.out.println("Final Score: " + score + "/" + questions.size());
    }
}
