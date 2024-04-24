/**
 * Class to represent a playing card in the game Baccarat
 * Extends the class Card
 */
public class BaccaratCard extends Card {

    private Card card;

    // constructor makes a card object
    public BaccaratCard(Rank r, Suit s) {
        super(r, s);
        this.card = new Card(r, s);
    }

    /**
     * Returns the integer value of a card.
     * 
     * @return integer value of card.
     */
    @Override
    public int value() {
        int val = this.card.value();
        if (val == 10) {
            val = 0;
        }
        return val;
    }
}