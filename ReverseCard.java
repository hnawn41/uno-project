public class ReverseCard extends Card implements Actionable {
    public ReverseCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
        if (other == null) return false;
       // if same color or other is also reverse card
        if (other instanceof ReverseCard) {
            return true;
        }
        // other is NumberCard or other ActionCard: match if same color
        return this.color == other.getColor();
    }

    @Override
    public void applyAction() {
        // Logic to reverse the direction of play
        System.out.println("Play direction is reversed!");
    }
    
}
