// TODO: Implement the Shoe class in this file
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Shoe extends CardCollection{

    private int decks;
    protected List<BaccaratCard> cardss;

    public Shoe(int decks) {
        cardss = new LinkedList<>();
        if (decks == 6 || decks == 8){
            this.decks = decks;
        } else {
            throw new CardException("Invalid number of decks");
        }
        // now must initialize the deck and add cards
        for (int j = 0; j < this.decks; j++){           
            for (Card.Suit suit : Card.Suit.values()) {
                for (Card.Rank rank : Card.Rank.values()) {
                    cardss.add(new BaccaratCard(rank, suit));
                }
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cardss);
    }

    public BaccaratCard deal(){ 
        if (size() == 0){
            throw new CardException("Can't deal from an empty deck");
        } 
        if (size() > 52){
            return cardss.remove(52-13); // as cards are ordered in order of unicode character
        } else {
            return cardss.remove(0);
        }
    }

      public int size(){
        return cardss.size();
    }


}