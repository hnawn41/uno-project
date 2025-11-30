public class DrawTwoCard  extends Card implements Actionable {
    public DrawTwoCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
        if (other == null) return false;
        if (other instanceof DrawTwoCard) {
            return true;
        }

        return this.color == other.getColor();
    }

    @Override
    public void applyAction() {
        // Logic to make the next player draw two cards
        System.out.println("Next player draws two cards!");
    }
    
}
