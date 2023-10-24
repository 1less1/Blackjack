package blackjack;

public class GameDriver {

    public static void main(String args[]) {
        SimplePlayer john = new SimplePlayer("John");
        Dealer dealer = new Dealer("Dealer");
        Game g = new Game(1,john,dealer);
        g.playRound(5);


    }
}
