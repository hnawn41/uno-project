

public abstract class Card {

    protected Color color;


    protected Card(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean matches(Card topCard);
    
    
}
