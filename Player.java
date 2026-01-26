import java.util.ArrayList;
import java.util.List;


public class Player {
  
    private  String name ;                                // attributes :
    private  List<Card> hand;


   public Player(String name ) {
        this.name  = name ;                              // constractor 
        this.hand = new ArrayList<>();             
    }




public int handSize() {
        return hand.size();  //displays the size of the hand
    }

public void playcard(int cardIndex , Game game){
     
   if (cardIndex < 0 || cardIndex >= hand.size()) {
            System.out.println("Invalid card index!");
            return;
        }
        Card chosenCard = hand.get(cardIndex);
         //the checking of the condittion
         if (chosenCard.matches(game.getCurrentCard())) {
           hand.remove(cardIndex);
         // 6. Show what happened
             System.out.println("Player " + name + " plays → " + chosenCard);
             if (hand.size() == 1) {
                System.out.println("Player " + name  + " : UNOOO!"); // if the player has one card left he says UNO
             } else if (hand.isEmpty()) {
                System.out.println("Player " + name + " has won the game!"); // if the player has no cards left he wins
             }

         } else {
            System.out.println("You cannot play this card!");
         }

       

}

public void addToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }


public void  sayUNO() {
        if (hand.size() == 1) {
            System.out.println("Player " + name  + " : UNOOO!"); // if the player has one card left he says UNO
        }else {
            System.out.println("You cannot say UNO now! You have " + hand.size() + " cards.");
        }
    }


   public String getname () {
        return name ;     //geter for the name  
    }

    @Override
    public String toString() {
        return "Player " + name  + " (" + hand.size() + " cards)";
    }

    public boolean hasWon() {
        return hand.isEmpty();  //checks if the player has won
    }
 
}