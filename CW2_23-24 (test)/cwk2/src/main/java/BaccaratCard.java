// TODO: Implement the BaccaratCard class in this file

public class BaccaratCard extends Card{

    private Card card;

    public BaccaratCard(Rank r, Suit s) {
        super(r, s);
        this.card = new Card(r,s);
    }

    @Override
    public int value(){
        int val = this.card.value();
        if (val == 10){
            val =0;
        }
        return val;
    }
}