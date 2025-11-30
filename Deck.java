import java.util.ArrayList; //beacause shuffling is better in array then linked list
// i used the predefined method: isempty, remove
import java.util.Collections;
import java.util.List;

import javax.smartcardio.Card;

public class Deck{
    private List <Card> cards; // they are of type Card (the class)


    //constructor
    public Deck(Card cards){
      this.cards = new ArrayList<>(108);

    };

   // public void createAllcards(){
    // Color[] colors={ Color.BLACK(0), Color.RED(1), Color.YELLOW(4), Color.GREEN(2), Color.BLUE(3),}


    public Card drawcard(){
        if(isEmpty()){//check if the deck is emty
            return null;//?
        }
      //remove(int);  //that remove the top of the deck
      //it is a predefined method from java.util arraylist
      return cards.remove(0);
    }

    //shuffle the deck
    public void shuffle(){
      Collections.shuffle(cards);//??
    }

    //isEmty to check if the deck is empty
    public boolean isEmpty(){//this method already exist in arraylist
        return cards.isEmpty();//return true if there's no element
    }
}