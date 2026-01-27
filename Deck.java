import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    // we just create cards
    public Deck() {
        createCards();
    }

    // Create all 108 UNO cards
    public void createCards() {
        Color[] colors = { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE };

        for (Color c : colors) {
            // Number cards
            cards.add(new NumberCard(c, 0)); // one 0 per color
            for (int i = 1; i <= 9; i++) {
                cards.add(new NumberCard(c, i));
                cards.add(new NumberCard(c, i)); // two of each 1-9
            }

            // Action cards: 2 each per color
            cards.add(new SkipCard(c));
            cards.add(new SkipCard(c));

            cards.add(new ReverseCard(c));
            cards.add(new ReverseCard(c));

            cards.add(new DrawTwoCard(c));
            cards.add(new DrawTwoCard(c));
        }

        // Wild cards: 4 each
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard(WildType.WILD));
            cards.add(new WildCard(WildType.WILD_DRAW_FOUR));
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw the top card
    public Card draw() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    // Check if empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Refill deck with a list of cards (from discard pile)
    public void refill(List<Card> newCards) {
        cards.addAll(newCards);
        shuffle();
    }
}
