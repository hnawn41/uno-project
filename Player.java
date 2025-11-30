
import java.util.ArrayList;
import java.util.List;

/**
 * Player holds a hand of Card objects and exposes small API used by Game.
 */
public class Player {
    private int id;
    private List<Card> hand;

    public Player(int id) {
        this.id = id;
        this.hand = new ArrayList<>();
    }

    public int handSize() { return hand.size(); }

    public void receive(Card c) {
        if (c != null) hand.add(c);
    }

    public Card playCard(int cardIndex) {
        if (cardIndex < 0 || cardIndex >= hand.size()) {
           // we print 
              System.out.println("Player " + id + ": Invalid card index " + cardIndex);
              return null;
        } else {
        return hand.remove(cardIndex); }
    }

    public int getId() { return id; }

    public boolean hasWon() { return hand.isEmpty(); }

    public List<Card> getHand() { return hand; }

    public void sayUNO() {
        if (hand.size() == 1) {
            System.out.println("Player " + id + ": UNO!");
        } else {
            System.out.println("Player " + id + " cannot say UNO now, has " + hand.size() + " cards.");
        }
    }

   
}
