package blackjack;

public class GameDriver {

    public static void main(String args[]) {
        AtlanticCityDealer acdealer = new AtlanticCityDealer("Atlantic City Dealer");
        Dealer dealer = new Dealer("Dealer");
        AtlanticCityDealer bob = new AtlanticCityDealer("Bob");
        Game g = new Game(1,acdealer,dealer);
        g.playRound(500);


    }
}
