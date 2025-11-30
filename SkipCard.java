public class SkipCard extends Card implements Actionable {
    public SkipCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
        if (other == null) return false;
       // if same color or other is also skip card
        if (other instanceof SkipCard) {
            return true;
        }
        return this.color == other.getColor();
    }

    @Override
    public void applyAction() {
        // Logic to skip the next player's turn
        System.out.println("Next player's turn is skipped!");
    }
    
}
