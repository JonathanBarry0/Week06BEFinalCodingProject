package Week06FinalCodingProjectPackage;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	
	public Player(String name) {
		this.score = 0;
		this.name = name;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void describe() {
		System.out.println("Player, " + this.name + ", has a score of: " + this.score + ". Their cards are: ");
		for (Card card : this.hand) {
			card.describe();
		}
	}
	
	public Card flip() {
		Card card = this.hand.remove(0);
		return card;
	}
	
	public void draw(Deck deck) {
		Card card = deck.draw();
		this.hand.add(card);
	}
	
	public int incrementScore() {
		this.score++;
		return score;
	}

}
