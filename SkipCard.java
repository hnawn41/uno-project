public class SkipCard extends ActionCard {

    public SkipCard(Color color) {
        super(color);
    }

    @Override
    public void apply(Game game) {
        game.skipNextPlayer();
    }


     @Override
    public String toString() {
        return "SkipCard(" + color + ")";
    }
    
}