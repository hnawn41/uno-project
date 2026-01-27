import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public int handSize() {
        return hand.size();
    }

    // Attempt to play a card, returns the card if successful, else null
    public Card playCard(int cardIndex, Card topCard, Color currentColor) {
        if (cardIndex < 0 || cardIndex >= hand.size()) {
            System.out.println("Invalid card index!");
            return null;
        }

        Card chosenCard = hand.get(cardIndex);

        // Check if the card can be played on top of topCard
        if (chosenCard.matches(topCard )) {
            hand.remove(cardIndex);
            System.out.println(name + " plays → " + chosenCard);

            if (hand.size() == 1) {
                System.out.println(name + " says UNO!");
            } else if (hand.isEmpty()) {
                System.out.println(name + " has won the game!");
            }

            return chosenCard; // return the played card
        } else {
            System.out.println("You cannot play this card!");
            return null;
        }
    }

    public void addToHand(Card card) {
        if (card != null) hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void sayUNO() {
        if (hand.size() == 1) {
            System.out.println(name + " says UNO!");
        } else {
            System.out.println("You cannot say UNO now! You have " + hand.size() + " cards.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + hand.size() + " cards)";
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }
}
