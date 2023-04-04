import java.util.*;
import javax.swing.*;

public class DeckOfCards {
    private Stack<String> deck;
    private int cardsDealt;

    // constructor method to initialize a new deck of cards
    public DeckOfCards() {
        deck = new Stack<String>();
        String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

        // populate the deck with all possible combinations of suits and ranks
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.push(rank + " of " + suit);
            }
        }

        // set cardsDealt to 0, since no cards have been dealt yet
        cardsDealt = 0;
    }

    // method to shuffle the deck of cards
    public void shuffle() {
        Collections.shuffle(deck);
        cardsDealt = 0;
    }

    // method to deal the top card from the deck
    public String deal() {
        if (deck.isEmpty()) {
            return "No cards left in the deck";
        } else {
            cardsDealt++;
            return deck.pop();
        }
    }

    // method to determine whether card1 is higher in value than card2
    public boolean isHigher(String card1, String card2) {
        String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        int value1 = Arrays.asList(values).indexOf(card1.split(" ")[0]);
        int value2 = Arrays.asList(values).indexOf(card2.split(" ")[0]);
        return value2 > value1;
    }

    // main method to run the card game
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        String currentCard = deck.deal();
        JOptionPane.showMessageDialog(null, "The first card is: " + currentCard);
        while (!deck.deck.isEmpty()) {
            int option = JOptionPane.showOptionDialog(null,
                    "Current card: " + currentCard + "\nWill the next card be higher or lower?", "Guess the card",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Higher", "Lower" },
                    null);
            if (option == JOptionPane.CLOSED_OPTION) {
                break;
            }
            String guess = (option == JOptionPane.YES_OPTION) ? "h" : "l";
            String nextCard = deck.deal();
            boolean isHigher = deck.isHigher(currentCard, nextCard);
            if (isHigher && guess.equalsIgnoreCase("h") || !isHigher && guess.equalsIgnoreCase("l")) {
                JOptionPane.showMessageDialog(null, "Correct! The next card is: " + nextCard);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, the next card was: " + nextCard);
                break;
            }
            currentCard = nextCard;
        }
        JOptionPane.showMessageDialog(null, "Game over. You correctly guessed " + (deck.cardsDealt - 1) + " cards.");
    }
}