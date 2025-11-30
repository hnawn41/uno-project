public class WildCard extends Card implements Actionable {
    private  WildType type;
    private Color cardColor = color.BLACK;

    public WildCard(WildType type) {
        super(Color.BLACK);
        this.type = type; 
    }

    public WildType getType() {
        return type;
    }
    public Color getCardColor() {
        return cardColor;
    }

    public void chooseColor(Color color){
      // logic to choose color
      // we handle errors
      this.cardColor = color;
    }

    @Override
    public boolean matches(Card other) {
        return true; // Wild cards match any card
    }

    @Override
    public void applyAction() {
        System.out.println("Wild card played! Choose a new color.");
        if (type == WildType.WILD_DRAW_FOUR) {
            System.out.println("Wild Draw Four: next player draws 4.");
            // logic to make the next player draw four cards
        } else {
            System.out.println("[Action] Wild: color changed to " + cardColor);
        }
        // Logic to change the current color in the game
        
    }
    
}
