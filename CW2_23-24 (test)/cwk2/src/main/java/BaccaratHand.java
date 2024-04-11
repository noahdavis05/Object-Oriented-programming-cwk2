/**
 * A class to implement a hand of cards in Baccarat punto banco
 * 
 * @author Noah Davis scnd23@leeds.ac.uk
 */

public class BaccaratHand{

    private BaccaratCard card1; 
    private BaccaratCard card2;
    private BaccaratCard card3;
    private int pointer;

    // Constructor initializes pointer attribute.
    public BaccaratHand(){
        this.pointer = 0;
    }

    /**
     * Returns the size of the hand.
     */
    public int size(){
        return this.pointer;
    }

    /**
     * This function takes a BaccaratCard as an input and stores it in this object.
     * Unless the hand is already full.
     * @param card BaccaratCard object.
     */
    public void add(BaccaratCard card){ // this has been changed from Card to BaccaratCard
        this.pointer++;
        if (this.pointer == 1)
        {
            this.card1 = card;
        } 
        else if (this.pointer == 2)
        {
            this.card2 = card;
        } 
        else if (this.pointer == 3)
        {
            this.card3 = card;
        }

    }

    /**
     * Method returns the value of the hand
     * @return integer - value of the hand
     */
    public int value(){
        // get the values of all the cards
        int total = 0;
        if (this.card1 != null)
        {
            total += this.card1.value();
        }
        if (this.card2 != null)
        {
            total += this.card2.value();
        }
        if (this.card3 != null)
        {
            total += this.card3.value();
        }
        // now we have the sum must get the correct hand value by modulus 10
        return total % 10;
    }

    /**
     * Checks if the hand is a natural, (value = 8 or 9).
     * @return boolean true if natural false if not.
     */
    public boolean isNatural(){
        // check if slots 1&2 aren't null and 3 is and if value of slots 1 and 2 = 8 or 9
        if (card1 != null && card2 != null & card3 == null)
        {
            if (this.value() == 8 || this.value() == 9)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the string representation of the hand.
     * @return String representing the hand.
     */
    public String toString(){
        String result = "";
        if (this.card1 != null)
        {
            result += this.card1.toString();
            result+=" ";
        }
        if (this.card2 != null)
        {
            result += this.card2.toString(); 
            result+=" ";
        }
        if (this.card3 != null)
        {
            result += this.card3.toString(); 
            result+=" ";
        }
        // this section removes the last space in the string as the tests fail if there is one.
        if (!result.isEmpty()) 
        {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * Resets the hand so that all cards are null and pointer = 0
     * Allows new cards to be added.
     */
    public void resetHand(){
        this.card1 = null;
        this.card2 = null;
        this.card3 = null;
        this.pointer = 0;
    }
}