package blackjack;

public class GameDriver {

    public static void main(String args[]) {
        AtlanticCityDealer acdealer = new AtlanticCityDealer("Atlantic City Dealer");
        Dealer dealer = new Dealer("Dealer");
        CountingPlayer cp = new CountingPlayer("Shark");
        Game g = new Game(2,cp,acdealer);
        g.playRound(1000);



    }
}
