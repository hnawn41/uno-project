public class DrawTwoCard extends ActionCard {
    public DrawTwoCard(Color color) {
        super(color);
    }

    @Override
    public void apply(Game game) {
        game.drawCardsForNextPlayer(2);
    }

    @Override
    public String toString() {
        return "DrawTwoCard(" + color + ")";
    }
}
