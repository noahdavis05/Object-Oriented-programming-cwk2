// TODO: Implement the BaccaratHand class in the file
public class BaccaratHand{

    private BaccaratCard card1; 
    private BaccaratCard card2;
    private BaccaratCard card3;
    private int pointer;

    public BaccaratHand(){
        this.pointer = 0;
    }

    public int size(){
        return this.pointer;
    }

    public void add(BaccaratCard card){ // this has been changed from Card to BaccaratCard
        this.pointer++;
        if (this.pointer == 1){
            this.card1 = card;
        } else if (this.pointer == 2){
            this.card2 = card;
        } else if (this.pointer == 3){
            this.card3 = card;
        }

    }

    public int value(){
        // get the values of all the cards
        int total = 0;
        if (this.card1 != null){
            total += this.card1.value();
        }
        if (this.card2 != null){
            total += this.card2.value();
        }
        if (this.card3 != null){
            total += this.card1.value();
        }
        // now we have the sum must get the correct hand value
        return total % 10;
    }

    public boolean isNatural(){
        // check if slots are null and if value of slots 1 and 2 = 8 or 9
        if (card1 != null && card2 != null & card3 == null){
            if (this.value() == 8 || this.value() == 9){
                return true;
            }
        }

        return false;
    }

    public String toString(){
        String result = "";
        if (this.card1 != null){result += this.card1.toString(); result+=" ";}
        if (this.card2 != null){result += this.card2.toString(); result+=" ";}
        if (this.card3 != null){result += this.card3.toString(); result+=" ";}
        // this section removes the last space in the string as the tests fail if there is one.
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}