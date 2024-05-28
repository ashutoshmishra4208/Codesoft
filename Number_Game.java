import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 5;
            int score = 0;

            System.out.println("\nRound " + (rounds + 1));

            while (attempts > 0) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score = attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attempts--;
            }

            if (attempts == 0) {
                System.out.println("Sorry, you ran out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Your score for this round: " + score);
            totalScore += score;

            rounds++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Total score: " + totalScore);
        System.out.println("Average score per round: " + (totalScore / (double) rounds));
    }
}