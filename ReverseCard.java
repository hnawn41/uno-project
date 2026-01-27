public class ReverseCard extends ActionCard {
    public ReverseCard(Color color) {
        super(color);
    }

    @Override
    public void apply(Game game) {
        game.reverseDirection();
    }

    @Override
    public String toString() {
        return "ReverseCard(" + color + ")";
    }
}
