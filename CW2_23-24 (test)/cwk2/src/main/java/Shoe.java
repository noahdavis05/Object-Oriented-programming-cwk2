// TODO: Implement the Shoe class in this file
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

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
        sort(); // this sorts the code into all clubs then all diamonds, all hearts, all spades and can be later shuffled
    }

    public void shuffle(){
        Collections.shuffle(cardss);
    }

    public BaccaratCard deal(){ 
        if (size() == 0){
            throw new CardException("Can't deal from an empty deck");
        } 

            return cardss.remove(0);

    }

    public int size(){
        return cardss.size();
    }

    @Override
    public void sort(){
        cardss.sort(Comparator.comparing(card -> card.getSuit().toString()));
    }

}