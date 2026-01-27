public class WildCard extends Card implements Actionable {
    private final WildType type;

    public WildCard(WildType type) {
        super(Color.BLACK); 
        this.type = type;
    }

    @Override
    public boolean matches(Card topCard, Color currentColor) {
        // since wild cards can always be played regardless of the current color or number 
        return true; 
    }

    @Override
    public void apply(Game game) {
        // we ask current player for color choice 
        Color chosenColor = game.askColorChoice();
        game.setCurrentColor(chosenColor);

        // case of Wild Draw Four
        if (type == WildType.WILD_DRAW_FOUR) {
            System.out.println("Wild Draw Four played! Next player draws 4 cards.");
            game.drawCardsForNextPlayer(4);
        }
    }

    @Override
    public String toString() {
        return type == WildType.WILD ? "Wild" : "Wild Draw Four";
    }
}