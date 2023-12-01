/*********************************
	Daimyan Thomas
	CIST 2371
	Mini-Project 2
**********************************/
import java.util.Scanner;
import java.util.Random;



public class SpinWheel {
	private static final int MAX_SPINS_PER_PLAYER = 2;
	private static final Scanner scan = new Scanner(System.in);
	
	//Generates a random multiple of 5 between 0 and 100.
	public static int spinWheel() {
		int spin = (int) (Math.random() * 21) * 5;
		return spin;
	}
	
	/* 3 Players will each spin the wheel.
	 * Every player has two spins. The total score of a player cannot go above 100.
	 * If player hits 100 exactly they are offered a bonus prize.
	 * If player goes above 100, they are disqualified to win.
	 */
	public static void playGame() {
		int[] playerScore = new int[3];
		
		for(int i = 0; i < playerScore.length; i++) {
			System.out.println("\nPlayer " + (i + 1) + ", it is your turn to spin the wheel.");
			int numSpin = 0;
			while (numSpin < MAX_SPINS_PER_PLAYER && playerScore[i] < 100) {
				int number = spinWheel();
				System.out.println("You spun: " + number + ".");
				playerScore[i] += number;
				if(playerScore[i] > 100) {
					System.out.println("Sorry, you went over 100. You're out!");
					break;
				}
				if(playerScore[i] == 100) {
					playerScore[i] += overHundred();
					break;
				}
				System.out.println("Your current score is " + playerScore[i] + ".");
				if(numSpin == 0 && playerScore[i] < 100) {
					System.out.println("Do you want to spin again? (y/n)");
					String answer = scan.nextLine();
					if(!answer.equalsIgnoreCase("y")) {
						break;
					}
				}
				numSpin++;
			}
		}
		checkWinner(playerScore);
	}
	
	//If player hits 100, they can spin again for prizes. 5, 10, and 100 are the only values that give the bonus prize.
	public static int overHundred() {
		System.out.println("Congrats, you hit 100 exactly! If you hit 5, 15, or 100 on your bonus spin you get extra points.");
		int extraSpin = spinWheel();
		System.out.println("Your bonus spin value is: " + extraSpin + ".");
		if(extraSpin == 100) {
			System.out.println("You win a bonus of $25,000!");
			return 25000;
		} else if(extraSpin == 5 || extraSpin == 15) {
			System.out.println("You win a bonus of $15,000!");
			return 15000;
		}
		return 0;
	}
	
	//Will check which player won the game. Any score between 100 and 200 is disqualified and unable to win. Bonus prize winners are ignored.
	public static void checkWinner(int[] score) {
		System.out.println("\nEnd results:");
		for(int i = 0; i < score.length; i++) {
			System.out.println("Player " + (i + 1) + " scored " + score[i] + ".");
			if(score[i] > 100 && score[i] < 200) {
				score[i] = 0;
			}
		}
		if(score[0] > score[1] && score[0] > score[2]) {
			System.out.println("Player 1 is the winner with " + score[0] + " points!");
		} else if(score[1] > score[0] && score[1] > score[2]) {
			System.out.println("Player 2 is the winner with " + score[1] + " points!");
		} else {
			System.out.println("Player 3 is the winner with " + score[2] + " points!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the spin game!");
		boolean sentinel = true;
		while (sentinel) {
			playGame();
			System.out.println("Do you want to play again? (y/n)");
			String answer = scan.nextLine();
			sentinel = answer.equalsIgnoreCase("y");
		}
		System.out.println("Thanks for playing!");
	}//end main
}//end class