package blackjack;

public class Game {

    public Shoe shoe;
    public Player player1;
    public Player player2;

    Hand player1Hand;
    Hand player2Hand;

    public Integer player1Record=0;
    public Integer player2Record=0;

    public Game(Integer numDecks, Player player1, Player player2) {
        this.shoe= new Shoe(numDecks);
        this.player1=player1;
        this.player2=player2;

    }

    public void playRound(Integer numRounds) {
        player1Hand =  new Hand(shoe);
        player2Hand = new Hand(shoe);


        for (int i=0; i<numRounds; i++) {
            //play game
            checkShoe();
            takeTurns();

            System.out.println(player1.getName()+"'s "+ getPlayer1Hand());
            System.out.println(player2.getName()+"'s "+ getPlayer2Hand());

            determineWinner();

            newHands();
        }
        displayRecords();

    }


    public void hitter(Hand h) {
        h.hitHand(shoe.drawCard());
    }

    public void takeTurns() {
        while (player1.willHitHand(player1Hand) && player1Hand.noBust()) {
            hitter(player1Hand);
        }

        if (player1Hand.noBust()) {
            player2.seeOpponentsCards(player1Hand);
            while(player2.willHitHand(player2Hand) && player2Hand.noBust()) {
                hitter(player2Hand);
            }
        }

    }

    public void determineWinner() {
        if (player2Hand.noBust() && (Math.abs(21-player2Hand.handScore)<Math.abs(21-player1Hand.handScore) || !player1Hand.noBust()) ){
            player2Record+=1;
            System.out.println(player2.getName()+" wins!");
        }
        else if (player1Hand.noBust() && (Math.abs(21-player1Hand.handScore)<Math.abs(21-player2Hand.handScore)) ) {
            player1Record+=1;
            System.out.println(player1.getName()+" wins!");
        }
        else {
            System.out.println("There has been a tie. No winner!");
        }

    }

    public void checkShoe() {
        if (shoe.getShoeSize()<16) {
            shoe.resetShoe();
            shoe.shuffle();
            player1.shoeWasReset(true);
            player2.shoeWasReset(true);
            //return true;
        } else {
            player1.shoeWasReset(false);
            player2.shoeWasReset(false);
            //return false;

        }
    }

    public void newHands() {
        player1Hand.newHand();
        player2Hand.newHand();
    }


    public void displayRecords() {
        System.out.println(player1.getName()+" has "+ player1Record + " wins");
        System.out.println(player2.getName()+" has "+ player2Record + " wins");

    }

    public Hand getPlayer1Hand() {
        return player1Hand;
    }

    public Hand getPlayer2Hand() {
        return player2Hand;
    }
}
