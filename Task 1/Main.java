import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0, roundsPlayed = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to Number Guessing Game!");

        while (playAgain) {
            int X = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 10;
            boolean guessedCorrectly = false;
            
            System.out.println("Here is randomly generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt "+ (attempts + 1) +": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < X) {
                    System.out.println("Too low! Try again");
                } else if (guess > X) {
                    System.out.println("Too high! Try again");
                } else {
                    System.out.println("Congratulations! You guessed the correct number");
                    totalScore++;
                    guessedCorrectly = true;
                    break;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was "+X);
            }
            
            roundsPlayed++;
            
            System.out.print("Do you want to play another round? (y/n): ");
            String playAgainInput = scanner.next().trim().toLowerCase();
            playAgain = playAgainInput.equals("y");
        }

        System.out.println("Game over! You played "+roundsPlayed+" rounds");
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
}
