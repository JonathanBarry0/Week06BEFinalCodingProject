package Week06FinalCodingProjectPackage;

import java.util.Scanner;

public class App {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		 System.out.print("Please enter the name for Player1: ");
	     String p1Name = sc.next();
	     System.out.print("Please enter the name for Player2: ");
	     String p2Name = sc.next();
		
		// 1. Instantiate a Deck and two Players, call the shuffle method on the deck.
		Deck deck = new Deck();
		Player player1 = new Player(p1Name);
		Player player2 = new Player(p2Name);
		deck.shuffle();
		
		// 2. Using a traditional for loop, iterate 52 times calling the Draw method on the other player each 
		// iteration using the Deck you instantiated.
		for (int i = 1; i <= 52; i++) {
			if (i % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
		
		// 3. Using a traditional for loop, iterate 26 times and call the flip method for each player.
		for (int j = 1; j <= 26; j++) {
			Card p1Card = player1.flip();
			System.out.println(player1.getName() + " flipped a(n): ");
			p1Card.describe();
			System.out.println("-");
			Card p2Card = player2.flip();
			System.out.println(player2.getName() + " flipped a(n): ");
			p2Card.describe();
			System.out.println("-");
			
			// 4. Compare the value of each card returned by the two player’s flip methods. Call the 
			// incrementScore method on the player whose card has the higher value.
			if (p1Card.getValue() > p2Card.getValue()) {
				System.out.println(
						p1Card.getValue() + " is more than " + p2Card.getValue() + ", so " + player1.getName() + " earns the point!"
				);
				player1.incrementScore();
				System.out.println("-");
				System.out.println(player1.getName() + "'s score is: " + player1.getScore());
				System.out.println(player2.getName() + "'s score is: " + player2.getScore());
				System.out.println("----------------------------------------------------------------");
			} else if (p2Card.getValue() > p1Card.getValue()) {
				System.out.println(
						p2Card.getValue() + " is more than " + p1Card.getValue() + ", so " + player2.getName() + " earns the point!"
				);
				player2.incrementScore();
				System.out.println("-");
				System.out.println(player1.getName() + "'s score is: " + player1.getScore());
				System.out.println(player2.getName() + "'s score is: " + player2.getScore());
				System.out.println("----------------------------------------------------------------");
			} else if (p1Card.getValue() == p2Card.getValue()) {
				System.out.println(
						p2Card.getValue() + " is equal to " + p1Card.getValue() + ", so no one earns the point!"
				);
				System.out.println("-");
				System.out.println(player1.getName() + "'s score is: " + player1.getScore());
				System.out.println(player2.getName() + "'s score is: " + player2.getScore());
				System.out.println("----------------------------------------------------------------");
			}
		}
		
		// 5. After the loop, compare the final score from each player.
		System.out.println(player1.getName() + "'s final score is: " + player1.getScore());
		System.out.println(player2.getName() + "'s final score is: " + player2.getScore());
		System.out.println("-");
		
		// 6. Print the final score of each player and either “Player 1”, “Player 2”, or “Draw” 
		// depending on which score is higher or if they are both the same.
		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName().toUpperCase() + " WINS!!!");
		} else if (player1.getScore() < player2.getScore()) {
			System.out.println(player2.getName().toUpperCase() + " WINS!!!");
		} else if (player1.getScore() == player2.getScore()) {
			System.out.println("IT'S A DRAW!!!");
		}

	}

}
