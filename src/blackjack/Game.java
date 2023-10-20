package blackjack;

public class Game {

    public Player player;
    public Player opponent;

    public Shoe shoe;
    public Hand playerHand;
    public Hand oppHand;

    public Hand oldPlayerHand;
    public Hand oldOppHand;

    public Integer playerRecord=0;
    public Integer oppRecord =0;

    public Game(Integer shoeSize) {
        shoe = new Shoe(shoeSize);
    }

    public void playRound(Boolean y) {
        if (y) {
            shoe.shuffle();
            playerHand = new Hand(shoe);
            oppHand = new Hand(shoe);
            player = new SimplePlayer("Ishimwe",shoe, playerHand);
            opponent = new Dealer("Dealer",shoe, oppHand, playerHand);

            System.out.println("Round Start!!!!");

            takeTurns();

            determineWinner();

            getHands();
            checkShoe();
            System.out.println();

            // Last round's hands for each player
            oldPlayerHand=playerHand;
            oldOppHand=oppHand;


            

        }
    }

    public void displayRecords() {
        System.out.println(player.getName()+" has "+playerRecord+ " wins");
        System.out.println(opponent.getName()+" has "+ oppRecord + " wins");

    }

    public void takeTurns() {
        while (player.willHitHand() && playerHand.noBust()) {
            player.hitter();
        }

        if (playerHand.noBust()) {
            while(opponent.willHitHand() && oppHand.noBust()) {
                opponent.hitter();
            }
        }
    }

    public void determineWinner() {

        if (playerHand.noBust() && (Math.abs(21-playerHand.handScore)<Math.abs(21-oppHand.handScore)) ) {
            playerRecord+=1;
            System.out.println(player.getName()+" wins!");
        }
        else if (playerHand.handScore!=oppHand.handScore){
            oppRecord+=1;
            System.out.println(opponent.getName()+" wins!");
        }

    }

    public void getHands() {
        System.out.println(player.getName()+"'s "+playerHand);
        System.out.println(opponent.getName()+"'s "+ oppHand);
    }

    public boolean checkShoe() {
        if (shoe.getShoeSize()<16) {
            shoe.resetShoe();
            return true;
        } else {
            return false;
        }
    }

    public void getLastRoundHands() {
        System.out.print("Last Round");
        System.out.println(oldPlayerHand);
        System.out.println(oldOppHand);
    }


}
