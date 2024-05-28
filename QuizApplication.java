import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctAnswer;

    public QuizQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizApplication {
    private static final int QUESTION_TIME_LIMIT = 5; // Time limit in seconds
    private static final QuizQuestion[] questions = {
        new QuizQuestion("What is the capital of France?",
                         new String[]{"Paris", "London", "Berlin", "Madrid"}, 1),
        new QuizQuestion("What is the largest ocean on Earth?",
                         new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 4),
        new QuizQuestion("What is the smallest planet in our solar system?",
                         new String[]{"Mercury", "Venus", "Mars", "Earth"}, 1)
    };

    private static int score = 0;
    private static int currentQuestionIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");

        while (currentQuestionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[currentQuestionIndex];
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());

            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + currentQuestion.getOptions()[i]);
            }

            System.out.print("Enter your answer (1-" + currentQuestion.getOptions().length + "): ");
            int userAnswer = scanner.nextInt();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! The correct answer is " + currentQuestion.getOptions()[currentQuestion.getCorrectAnswer() - 1]);
                    currentQuestionIndex++;
                    timer.cancel();
                }
            }, QUESTION_TIME_LIMIT * 1);

            int selectedAnswer = getUserAnswer(scanner, currentQuestion.getOptions().length);
            timer.cancel();

            if (selectedAnswer == currentQuestion.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + currentQuestion.getOptions()[currentQuestion.getCorrectAnswer() - 1]);
            }

            currentQuestionIndex++;
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.length);
        System.out.println("Correct answers: " + score);
        System.out.println("Incorrect answers: " + (questions.length - score));
    }

    private static int getUserAnswer(Scanner scanner, int maxOptions) {
        while (true) {
            int answer = scanner.nextInt();
            if (answer >= 1 && answer <= maxOptions) {
                return answer;
            } else {
                System.out.print("Invalid answer. Please enter a number between 1 and " + maxOptions + ": ");
            }
        }
    }
}