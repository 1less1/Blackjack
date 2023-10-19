package blackjack;

public class Game {

    public Player player1;
    public Player dealer;

    public Integer shoeSize;

    public Shoe shoe;
    public Hand playerHand;
    public Hand dealerHand;

    public Integer playerRecord=0;
    public Integer dealerRecord=0;

    //public Boolean playRound;

    public Game(Integer shoeSize) {
        shoe = new Shoe(shoeSize);
    }

    public void playRound(Boolean y) {
        if (y==true) {
            shoe.shuffle();
            playerHand = new Hand(shoe);
            dealerHand = new Hand(shoe);
            player1 = new SimplePlayer("Dom",shoe, playerHand);
            dealer = new Dealer("Dealer",shoe, dealerHand,playerHand);

            System.out.println("Round Start!!!!");

            while (player1.willHitHand() && playerHand.noBust()) {
                player1.hitter();
                //System.out.println(playerHand);
            }

            if (playerHand.noBust()) {
                while(dealer.willHitHand() && dealerHand.noBust()) {
                    dealer.hitter();
                    //System.out.println(dealerHand);
                }
            }




            if (playerHand.noBust() && (((21-playerHand.handScore) < (21-dealerHand.handScore)) || dealerHand.noBust()==false)) {
                playerRecord += 1;
                System.out.println(player1.getName() + " wins!");
            } else {
                dealerRecord+=1;
                System.out.println(dealer.getName()+" wins!");
            }

            System.out.println(player1.getName()+"'s "+playerHand);
            System.out.println(dealer.getName()+"'s "+dealerHand);
            System.out.println("");





        }
    }

    public void displayRecords() {
        System.out.println(player1.getName()+" has "+playerRecord+ " wins");
        System.out.println(dealer.getName()+" has "+dealerRecord+ " wins");

    }



}
