import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int round = 1;
        int totalScore = 0;
        String playAgain;
        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");
        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;
            System.out.println("\nRound " + round);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");
            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }
                int guess = scanner.nextInt();
                if (guess<1||guess>100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }
                attempts++;
                if (guess > secretNumber) {
                    System.out.println("Too High!");
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct!");
                    System.out.println("You guessed the number in "+attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1);
                    break;
                }
            System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }
            if (!guessedCorrectly) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: "
                        + secretNumber);
            }
            System.out.println("\n---------- Round Summary ----------");
            System.out.println("Round: " + round);
            System.out.println("Attempts used: " + attempts);
            if (guessedCorrectly) {
                System.out.println("Result: Won");
            } else {
                System.out.println("Result: Lost");
            }
            System.out.println("Total Score: " + totalScore);
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();
            round++;
        } while (playAgain.equalsIgnoreCase("yes"));
        System.out.println("\n=================================");
        System.out.println("       GAME OVER");
        System.out.println("Final Score: " + totalScore);
        System.out.println("=================================");
        scanner.close();
    }
}