import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

/**
 * Class to make shoe objects which contain 6-8 decks of cards.
 * Extends CardCollection.
 */
public class Shoe extends CardCollection{

    private int decks;
    protected List<BaccaratCard> cardss;

    /**
     * Constructor only allows decks to be 6 or 8.
     * The constructor then fills the shoe with 6 or 8 decks of cards.
     * @param decks integer to decide how many decks you want in the shoe.
     */
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

    /**
     * Shuffles the cards in the shoe to a random order.
     */
    public void shuffle(){
        Collections.shuffle(cardss);
    }

    /**
     * Returns the card at the bottom of the shoe to be dealt and removed from the shoe.
     * @return
     */
    public BaccaratCard deal(){ 
        if (size() == 0)
        {
            throw new CardException("Can't deal from an empty deck");
        } 
        return cardss.remove(0);
    }

    /**
     * Returns the number of cards in the shoe
     * @return integer num of cards.
     */
    public int size(){
        return cardss.size();
    }

    /**
     * Sorts the cards in the deck into correct order.
     */
    @Override
    public void sort(){
        cardss.sort(Comparator.comparing(card -> card.getSuit().toString()));
    }

}