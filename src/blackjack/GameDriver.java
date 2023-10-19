package blackjack;

public class GameDriver {

    public static void main (String args[]) {
        Game g = new Game(2);
        g.playRound(true);
        g.playRound(true);
        g.playRound(true);
        g.displayRecords();
    }
}
