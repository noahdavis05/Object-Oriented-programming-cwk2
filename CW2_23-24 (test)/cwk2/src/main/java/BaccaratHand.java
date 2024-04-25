import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A class extending CardCollection altered for baccarat.
 */
public class BaccaratHand extends CardCollection {

    public BaccaratHand() {
        super(); 
    }

    /**
     * Method adds card to hand
     * 
     * @param card BaccaratCard object
     */
    public void add(BaccaratCard card) {
        if (card instanceof BaccaratCard && size() < 3) {
            super.add(card);
        }

    }

    /**
     * calculates the value of the hand in range from 0-9
     * 
     * @return integer
     */
    @Override
    public int value() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.value();
        }
        return sum % 10;
    }

    /**
     * method works out if hand is natural e.g. 2 cards value sum of 8 or 9
     * 
     * @return boolean
     */
    public boolean isNatural() {
        if (cards.size() == 2) {
            int total = cards.get(0).value() + cards.get(1).value();
            if (total == 8 || total == 9) {
                return true;
            }

        }
        return false;
    }

    /**
     * method works out the string representation of the hand and returns it
     * 
     * @return String object
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < cards.size(); i++) {
            result += cards.get(i).toString();
            result += " ";
        }
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

}