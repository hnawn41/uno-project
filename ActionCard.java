public abstract class ActionCard extends Card implements Actionable {
    protected ActionCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other) {
    if (other instanceof ActionCard) {
        return this.getClass() == other.getClass() || this.color == other.getColor();
    }
    return this.color == other.getColor();
}


}
