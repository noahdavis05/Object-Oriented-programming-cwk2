import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

/**
 * Class to make shoe objects which contain 6-8 decks of cards.
 * Extends CardCollection.
 */
public class Shoe extends CardCollection {

    private int decks;

    /**
     * Constructor only allows decks to be 6 or 8.
     * The constructor then fills the shoe with 6 or 8 decks of cards.
     * 
     * @param decks integer to decide how many decks you want in the shoe.
     */
    public Shoe(int decks) {
        super();

        if (decks != 6 && decks != 8) {
            throw new CardException("Invalid number of decks");
        }

        this.decks = decks;

        for (int j = 0; j < this.decks; j++) {
            for (Card.Suit suit : Card.Suit.values()) {
                for (Card.Rank rank : Card.Rank.values()) {
                    add(new BaccaratCard(rank, suit)); 
                }
            }
        }

    }

    /**
     * Shuffles the cards in the shoe to a random order.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Returns the card at the bottom of the shoe to be dealt and removed from the
     * shoe.
     * 
     * @return BaccaratCard object
     */
    public BaccaratCard deal() throws CardException {
        if (isEmpty()) {
            throw new CardException("Can't deal from an empty deck");
        }
        return (BaccaratCard) cards.remove(0);
    }

}