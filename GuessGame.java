/*********************************
	Daimyan Thomas
	CIST 2371
	Mini-Project 3
**********************************/
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	
	//Generate a random number between 1 and 100.
	public static int numGenerator() {
		int randomNum = (int) (Math.random() * 101) + 1;
		return randomNum;
	}
	
	/* Grabs a random number and the player guesses it.
	 * Will count the number of guesses and tell the player if the number is too high or too low.
	 */
	public static void playGame() {
		Scanner scan = new Scanner(System.in); 
		int number = numGenerator();
		System.out.println("Guess a number between 1 to 100: ");
		int answer = scan.nextInt();
		int numGuess = 1;
		
		while(answer != number) {
			if(answer > number) {
				System.out.println("Your guess was too high.");
				answer = scan.nextInt();
			} else {
				System.out.println("Your guess was too low.");
				answer = scan.nextInt();
			}
			numGuess++;
		}
		System.out.println("Your guess was correct. The number was " + answer + ".\nNumber of guesses: " + numGuess);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Welcome to the Guessing Game!");
		boolean sentinel = true;
		while(sentinel) {
			playGame();
			System.out.println("\nDo you want to play again? (y/n)");
			String answer = scan.nextLine();
			sentinel = answer.equalsIgnoreCase("y");
		}
		System.out.println("Thanks for playing!");
	}//end main
}//end class