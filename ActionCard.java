public abstract class ActionCard extends Card implements Actionable {
    protected ActionCard(Color color) {
        super(color);
    }

    @Override
    public boolean matches(Card other){
        return other instanceof ActionCard || this.color == other.getColor();
    }
    

}
