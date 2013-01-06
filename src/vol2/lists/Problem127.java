//Accordian Patience
package vol2.lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Stack;

public class Problem127 {
	private static BufferedReader br;
	private static final boolean DEBUG = false;
	
	private static class Card {
		private char rank;
		private char suit;
		
		Card (char rank, char suit) {
			this.rank = rank;
			this.suit = suit;
		}
		
		public boolean matches(Card card) {
			if (this.suit == card.suit ||
				this.rank == card.rank){
				return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			return "" + rank + suit;
		}
	}
	
	private static class Accordion {
		private static LinkedList<Stack<Card>> piles;
		
		public Accordion (String[] inputCards){
			piles = new LinkedList<Stack<Card>>();
			
			for (String inputCard : inputCards) {
				Stack<Card> pile = new Stack<Card>();
				
				pile.push(new Card(inputCard.charAt(0), inputCard.charAt(1)));
				piles.add(pile);
			}
		}
	
		public void play() {
			int i = 0;
			while (i < piles.size()) {
				//this.print();
				i = collapse(i);
			}
		}
	
		private static int collapse(int position) {
			Stack<Card> current = piles.get(position);
			
			if (position-3 >= 0) {
				Stack<Card> left3 = piles.get(position-3);
				if (current.peek().matches(left3.peek())) {
					debug("Moved " + current.toString() + " onto " + left3.toString());
					left3.push(current.pop());
					
					if (current.empty()) {
						piles.remove(current);
					}
					return collapse(position-3);
				}
			}
			
			if (position-1 >= 0) {
				Stack<Card> left1 = piles.get(position-1);
				if (current.peek().matches(left1.peek())) {
					debug("Moved " + current.toString() + " onto " + left1.toString());
					left1.push(current.pop());
					
					if (current.empty()) {
						piles.remove(current);
					}
					return collapse(position-1);
				}
			}
			
			return position+1;
		}
		
		public void print() {
			System.out.print(piles.size());
			if (piles.size() == 1) {
				System.out.print(" pile remaining:");
			}
			else {
				System.out.print(" piles remaining:");
			}
			
			for (Stack<Card> cardStack : piles) {
				System.out.print(" " + cardStack.size());
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol2/lists/Problem127");
		String deck;
		
		while (!(deck = br.readLine()).equals("#")) {
			deck += " " + br.readLine();
			String[] inputCards = deck.split("\\s+");
			
			Accordion game = new Accordion(inputCards);
			game.play();
			game.print();
		}
	}
	
	private static void debug(String message) {
		if (DEBUG == true) {
			System.out.println(message);
		}
	}
	
	private static BufferedReader getBufferedReader(String[] args, String path) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + path);
		else
			stdin = new InputStreamReader(System.in);
		
		return new BufferedReader(stdin);
	}
}
