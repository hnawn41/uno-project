

/***
 * Number card (0..9)
 */
public class NumberCard extends Card {

    private final int value;// form 0 to 9

    public NumberCard(Color color, int value) {
        super(color);
        // we gotta add verification
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public boolean matches(Card other) {
        if (other == null) return false;
        if (other instanceof NumberCard) {
            NumberCard n = (NumberCard) other;
            return this.color == n.color || this.value == n.value;
        }
        // other is action card: match if same color
        return this.color == other.getColor();
    }

   
}
