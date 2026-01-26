public class WildCard extends Card implements Actionable {
    private final WildType type;

    public WildCard(WildType type) {
        super(Color.BLACK);
        this.type = type;
    }

    @Override
    public boolean matches(Card other) {
        return true;
    }

    @Override
    public void apply(Game game) {
        Color chosenColor = game.askColorChoice();
        game.setCurrentColor(chosenColor);

        if (type == WildType.WILD_DRAW_FOUR)
            game.drawCardsForNextPlayer(4);
    }
}
