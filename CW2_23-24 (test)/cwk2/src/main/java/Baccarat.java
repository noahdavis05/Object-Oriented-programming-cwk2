public class Baccarat {
  // TODO: Implement your Baccarat simulation program here
  public static void main(String[] args){
    // firstly make a shoe with 6 decks
    Shoe myShoe = new Shoe(6);
    //System.out.println(myShoe.size());
    //myShoe.shuffle();
    BaccaratHand playerHand = new BaccaratHand();
    BaccaratHand bankHand = new BaccaratHand();
    //deal two cards to each
    playerHand.add(myShoe.deal());
    //bankHand.add(myShoe.deal());
    playerHand.add(myShoe.deal());
    //bankHand.add(myShoe.deal());
    playerHand.add(myShoe.deal());
    //bankHand.add(myShoe.deal());
    System.out.println(playerHand.toString());
    //System.out.println(bankHand.toString());
    


  }
}
