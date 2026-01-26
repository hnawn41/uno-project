import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        createCards();
        shuffle();
    }

    private void createCards() {
        for (Color c : Color.values()) {
            if (c == Color.BLACK) continue;

            cards.add(new NumberCard(c, 0));
            for (int i = 1; i <= 9; i++) {
                cards.add(new NumberCard(c, i));
                cards.add(new NumberCard(c, i));
            }

            cards.add(new SkipCard(c));
            cards.add(new SkipCard(c));
            cards.add(new ReverseCard(c));
            cards.add(new ReverseCard(c));
            cards.add(new DrawTwoCard(c));
            cards.add(new DrawTwoCard(c));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard(WildType.WILD));
            cards.add(new WildCard(WildType.WILD_DRAW_FOUR));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
