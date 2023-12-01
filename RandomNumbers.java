/*********************************
	Daimyan Thomas
	CIST 2371
	Mini-Project 1
**********************************/
import java.util.Scanner;
import java.util.Random;

public class RandomNumbers {
	/* Generate 1 or 2 random number(s) between 1 and 6. 
	 * Math.random() * 6 gives us a number between 0 and 5.
	 * By adding 1, the num will not include 0 & will include 6.
	 */
	public static int rollDie(boolean test) {
		int total = 0;
		int die1 = (int) (Math.random() * 6) + 1;
		System.out.println("The first die rolled: " + die1);
		total += die1;
		if(test == true) {
			int die2 = (int) (Math.random() * 6) + 1;
			System.out.println("The second die rolled: " + die2);
			total += die2;
		}
		return total;
	}
	
	
	/*Check the score of the player
	 *If the user gets 21, they win
	 *If the user gets over 21, they lose
	 */
	public static void checkWin(int score) {
		if(score > 21) {
			System.out.println("Your score went above 21. You Lose!");
		} else if(score == 21) {
			System.out.println("Your score hit exactly 21. You Win!");
		} else {
			System.out.println("Your score is " + score + ". Keep rolling to win!");
			userPrompt(score);
		}
	}
	
	//Asks the user if they want to roll again.
	public static void userPrompt(int score) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Roll the dice (y/n)? ");
		String answer = scan.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			if(score >= 15) {
				int current = rollDie(false);
				checkWin(score + current);
			} else {
				int current = rollDie(true);
				checkWin(score + current);
			}
		} else {
			System.out.println("Thanks for playing!");
			scan.close();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Twenty-One!");
		int firstRoll = rollDie(true);
		checkWin(firstRoll);
	}//end main
}//end class