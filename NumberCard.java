

/***
 * Number card (0 to 9)
 */
public class NumberCard extends Card {

    private final int value;// form 0 to 9

    public NumberCard(Color color, int value) {
        super(color);
        if ( value < 0 || value > 9) {
            throw new IllegalArgumentException("NumberCard value must be between 0 and 9");
        }
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public boolean matches(Card other) {
        if ( other instanceof NumberCard n ) {
            return color == n.color || value == n.value;
        } return color == other.getColor();
    }

   
}
