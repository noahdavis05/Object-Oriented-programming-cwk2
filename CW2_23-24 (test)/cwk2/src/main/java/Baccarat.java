
/**
 * A class to play the game Baccarat Punto Banco.
 * 
 * @author Noah Davis sc23nd@leeds.ac.uk
 */

import java.util.Scanner;

public class Baccarat {

  private BaccaratHand playerHand;
  private BaccaratHand bankHand;
  private Shoe myShoe;
  private int roundCount;
  private int pScore;
  private int bScore;
  private int playerWins;
  private int bankWins;
  private int ties;

  // Constructor. Initializes the shoe, hands, and variables.
  public Baccarat() {
    playerHand = new BaccaratHand();
    bankHand = new BaccaratHand();
    myShoe = new Shoe(6);
    roundCount = 0;
    playerWins = 0;
    bankWins = 0;
    ties = 0;
  }

  public static void main(String[] args) {
    // make an instance of this class to use.
    Baccarat game = new Baccarat();

    // shuffle the shoe before the game can begin
    game.myShoe.shuffle();

    // create a scanner object to read user inputs
    Scanner scanner = new Scanner(System.in);

    // while loop to allow the user to choose to play another round or stop.
    boolean cont = true;
    while (cont) 
    {
      // play a round of the game
      game.round();
      // ask user if they wish to continue
      System.out.print("Another round? (y/n): ");
      char ch = scanner.next().charAt(0);
      if (ch != 'Y' && ch != 'y') 
      {
        cont = false;
      } else 
      {
        // check if there are enough cards left in the shoe
        if (game.myShoe.size() < 6)
        {
          System.out.println("Too few cards in shoe, game over!");
          cont = false;
        }
        else 
        {
          // reset the hands at end of the round
          game.resetHands();
          System.out.println(" ");
        }
      }
    }

    // display the finishing results
    game.displayResults();
    scanner.close();
  }

  /**
   * Method deals two cards to the player and banker in turns.
   */
  public void dealCards() {
    playerHand.add(myShoe.deal());
    bankHand.add(myShoe.deal());
    playerHand.add(myShoe.deal());
    bankHand.add(myShoe.deal());
  }

  /**
   * Method displays the hands and scores of the player and banker to the terminal.
   */
  public void displayCards() {
    System.out.printf("Player: %s = %d\n", playerHand.toString(), playerHand.value());
    System.out.printf("Banker: %s = %d\n", bankHand.toString(), bankHand.value());
  }

  /**
   * Method runs each round of the game.
   * It deals cards to the hands, displays them, then scores the round.
   */
  public void round() {
    roundCount++;
    System.out.printf("Round %d\n", roundCount);
    dealCards();
    displayCards();
    pScore = playerHand.value();
    bScore = bankHand.value();
    scoreRound();
  }

  /**
   * Scores the round according to the tableau of drawing rules
   */
  public void scoreRound() {
    if (playerHand.isNatural() || bankHand.isNatural()) 
    {
      // choose the winner when either player has a natural
      chooseWinner();
    } 
    else if ((pScore == 6 || pScore == 7) && (bScore == 6 || bScore == 7)) 
    {
      // score if both players stand and don't draw a third
      chooseWinner();
    } 
    else if (pScore == 6 || pScore == 7) 
    {
      // bank draws an extra card when player stands
      bankHand.add(myShoe.deal());
      System.out.println("Drawing third card to bank...");
      pScore = playerHand.value();
      bScore = bankHand.value();
      displayCards();
      chooseWinner();
    } 
    else if (bScore == 7) 
    {
      // player draws extra card when bank stands
      playerHand.add(myShoe.deal());
      System.out.println("Drawing third card to player...");
      pScore = playerHand.value();
      bScore = bankHand.value();
      displayCards();
      chooseWinner();
    } 
    else 
    {
      // this is when the player hand has to pick a new card and the bank has to
      // depending on the rules
      dealBoth();

    }
  }

    /**
     * Method prints the result of the round
     * Updates the winners counter (bankWins, playerWins, or ties)
     */
  public void chooseWinner() {
    if (pScore > bScore) 
    {
      playerWins++;
      System.out.println("Player wins!");
    } 
    else if (pScore < bScore) 
    {
      bankWins++;
      System.out.println("Bank wins!");
    } 
    else 
    {
      ties++;
      System.out.println("Tie");
    }
  }

  /**
   * Method is called when the player and banker have to be (possibly dealt a third).
   * Banker being dealt a third hand depends on the tableau of drawing rules.
   * At the end the method displays the hands and chooses the winning hand.
   */
  public void dealBoth() {
    // deal the player a new card
    BaccaratCard temp = myShoe.deal();
    System.out.println("Drawing third card to player...");
    playerHand.add(temp);
    int val = temp.value();
    // now need to work out if the bank is to take a new card too
    if (bScore <= 2) 
    {
      // draw a third card no matter what
      bankHand.add(myShoe.deal());
      System.out.println("Drawing third card to bank...");
    } 
    else if (bScore == 3) 
    {
      // check if card val is not 8
      if (val != 8) 
      {
        bankHand.add(myShoe.deal());
        System.out.println("Drawing third card to bank...");
      }
    } 
    else if (bScore == 4) 
    {
      if (val <= 7 && val >= 2) 
      {
        bankHand.add(myShoe.deal());
        System.out.println("Drawing third card to bank...");
      }
    } 
    else if (bScore == 5) 
    {
      if (val <= 7 && val >= 4) 
      {
        bankHand.add(myShoe.deal());
        System.out.println("Drawing third card to bank...");
      }
    } 
    else if (bScore == 6) 
    {
      if (val == 6 || val == 7) 
      {
        bankHand.add(myShoe.deal());
        System.out.println("Drawing third card to bank...");
      }
    }

    //display hands and choose winner
    pScore = playerHand.value();
    bScore = bankHand.value();
    displayCards();
    chooseWinner();

  }

  /**
   * Method resets both hands.
   */
  public void resetHands() {
    playerHand.resetHand();
    bankHand.resetHand();
  }

  /**
   * Displays the results at the end of game
   * player wins, banker wins and ties.
   */
  public void displayResults() {
    System.out.println(" ");
    System.out.printf("%d rounds played\n", roundCount);
    System.out.printf("%d player wins\n", playerWins);
    System.out.printf("%d banker wins\n", bankWins);
    System.out.printf("%d ties\n", ties);
  }

}
