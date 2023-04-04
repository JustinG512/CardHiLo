import java.util.*;

public class DeckOfCards {
    private Stack<String> deck;
    private int cardsDealt;

    // constructor method to initialize a new deck of cards
    public DeckOfCards() {
        deck = new Stack<String>();
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

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
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int value1 = Arrays.asList(values).indexOf(card1.split(" ")[0]);
        int value2 = Arrays.asList(values).indexOf(card2.split(" ")[0]);
        return value2 > value1;
    }

    // main method to run the card game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        // deal the first card from the deck
        String currentCard = deck.deal();
        System.out.println("The first card is: " + currentCard);

        // prompt the user to guess whether the next card will be higher or lower
        while (!deck.deck.isEmpty()) {
            System.out.print("Will the next card be higher or lower? (h/l): ");
            String guess = scanner.nextLine();
            String nextCard = deck.deal();

            // determine whether the guess was correct
            boolean isHigher = deck.isHigher(currentCard, nextCard);
            if (isHigher && guess.equalsIgnoreCase("h") || !isHigher && guess.equalsIgnoreCase("l")) {
                System.out.println("Correct! The next card is: " + nextCard);
            } else {
                System.out.println("Sorry, the next card was: " + nextCard);
                break;
            }

            // update currentCard to be the card just dealt
            currentCard = nextCard;
        }

        // print the final score
        System.out.println("Game over. You correctly guessed " + (deck.cardsDealt - 1) + " cards.");
    }
}
