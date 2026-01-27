public abstract class ActionCard extends Card implements Actionable {
    protected ActionCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card topCard, Color currentColor) {
    // if color is matched
    if (this.color == currentColor) return true;

    // else if same type of action card
    return this.getClass() == topCard.getClass();
}


}
