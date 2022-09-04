package ie.gmit.dip;

import java.util.Scanner;

public class NumberGuessingGame {
	// Instance variables should always be private
	private final int MAX_GUESS = 10;
	private final int MAX_RANGE = 100;
	private final int MIN_RANGE = 1;
	private Scanner sc;
	private int number;

	public NumberGuessingGame() {
		sc = new Scanner(System.in);		
	}
	
	private void menu() {
		System.out.println("##########################################");
		System.out.println("########## Number Guessing Game ##########");
		System.out.println("##########################################");
	}
	
	private void rules() {
		System.out.println("################# Rules ##################");
		System.out.println("1) You have " + MAX_GUESS + " attemts to guess a number between " + MIN_RANGE + " and " + MAX_RANGE);
	}
	
	public void start() throws InterruptedException {

		this.menu();
		this.rules();
		
		number = (int) (Math.random() * MAX_RANGE); // integer value between 1 and 100
		
		boolean notGuessed = true;
		int counter = 0; // local
		
		
		while(notGuessed && counter < MAX_GUESS) {
			counter++;	// increment counter		
			System.out.println("Enter a number between 1 and " + MAX_RANGE + "\n[>]");
			int guess = Integer.parseInt(sc.next());
			
			if((guess >= MIN_RANGE) && (guess < MAX_RANGE)) {
				if(guess == number) {
					System.out.println("Correct! Well done.");
					System.out.println("You guessed the number correctly as " + number + " and it took you " + counter + " guesses.");
					System.out.println("You had " + (MAX_GUESS - counter) + " guesses remaining...\n");
					System.out.println("Exiting...");
//					Pause exit for 1 second
					Thread.sleep(4000);
					notGuessed = false;
					break;
				}else if(guess > number) {
					System.out.println("Too high!");
				}else {
					System.out.println("Too low!");
				}
				System.out.println("You have " + (MAX_GUESS - counter) + " guesses remaining...\n");
			}else {
				System.out.println(guess + " is not in the range of " + MIN_RANGE + "-" + MAX_RANGE);
			}
		}
		if(notGuessed) {
			System.out.println("Out of attempts... The correct answer was " + number);
		}
	}
	
	

}
