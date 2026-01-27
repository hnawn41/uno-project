

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
    public boolean matches(Card topCard, Color currentColor) {
    // if this card can be played on top of topCard given currentColor
    if (this.color == currentColor) return true;
    
    // if it's a number card, we check value
    if (topCard instanceof NumberCard n) {
        return this.value == n.getValue();
    }
    return false;
}


    
    @Override
    public String toString() {
        return "NumberCard(" + value + ", " + color + ")";
    }

   
}
