import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        
        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            
            int maxAttempts = 5;
            int attempts = 0;
            
            int score = 0;
            
            boolean guessedCorrectly = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            
            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Guess the number: ");
                int guess = scanner.nextInt();
                
                attempts++;
                
                if (guess == secretNumber) {
                    guessedCorrectly = true;
                    score = maxAttempts - attempts + 1;
                    System.out.println("Congratulations! You guessed the number correctly!");
                    System.out.println("Attempts: " + attempts);
                    System.out.println("Score: " + score);
                } else if (guess < secretNumber) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("You have reached the maximum number of attempts.");
                System.out.println("The secret number was: " + secretNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing the Number Guessing Game. Goodbye!");
        
        scanner.close();
    }
}
