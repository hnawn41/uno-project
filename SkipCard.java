public class skipCard extends ActionCard {

    public skipCard(Color color) {
        super(color);
    }

    @Override
    public void apply(Game game) {
        game.skipNextPlayer();
    }
    
}