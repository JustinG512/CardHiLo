import java.util.*;

public class DeckOfCards {
    private Stack<String> deck;
    private int cardsDealt;

    public DeckOfCards() {
        deck = new Stack<String>();
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.push(rank + " of " + suit);
            }
        }
        cardsDealt = 0;
    }

    public void shuffle() {
        Collections.shuffle(deck);
        cardsDealt = 0;
    }

    public String deal() {
        if (deck.isEmpty()) {
            return "No cards left in the deck";
        } else {
            cardsDealt++;
            return deck.pop();
        }
    }

    public boolean isHigher(String card1, String card2) {
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int value1 = Arrays.asList(values).indexOf(card1.split(" ")[0]);
        int value2 = Arrays.asList(values).indexOf(card2.split(" ")[0]);
        return value2 > value1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        String currentCard = deck.deal();
        System.out.println("The first card is: " + currentCard);
        while (!deck.deck.isEmpty()) {
            System.out.print("Will the next card be higher or lower? (h/l): ");
            String guess = scanner.nextLine();
            String nextCard = deck.deal();
            boolean isHigher = deck.isHigher(currentCard, nextCard);
            if (isHigher && guess.equalsIgnoreCase("h") || !isHigher && guess.equalsIgnoreCase("l")) {
                System.out.println("Correct! The next card is: " + nextCard);
            } else {
                System.out.println("Sorry, the next card was: " + nextCard);
                break;
            }
            currentCard = nextCard;
        }
        System.out.println("Game over. You correctly guessed " + (deck.cardsDealt - 1) + " cards.");
    }
}