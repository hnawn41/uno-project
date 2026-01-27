public class WildCard extends Card implements Actionable {
    private final WildType type;

    public WildCard(WildType type) {
        super(Color.BLACK);
        this.type = type;
    }

    @Override
    public boolean matches(Card other ) {
        return true; // wild cards can always be played
    }

    @Override
    public void apply(Game game) {
        // Ask current player for color choice
        Color chosenColor = game.askColorChoice();
        game.setCurrentColor(chosenColor);

        // Wild Draw Four effect
        if (type == WildType.WILD_DRAW_FOUR) {
            System.out.println("Wild Draw Four played! Next player draws 4 cards.");
            game.drawCardsForNextPlayer(4);
        } else {
            System.out.println("Wild card played! Color changed to " + chosenColor);
        }
    }

    @Override
    public String toString() {
        return type == WildType.WILD ? "Wild" : "Wild Draw Four";
    }
}
