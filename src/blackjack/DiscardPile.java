package blackjack;

import java.util.ArrayList;

public class DiscardPile {
    public ArrayList<Card> dp = new ArrayList<>();;

    //Hi-Lo counting strategy (Still working out kinks)
    public Integer runningCount;
    public Integer trueCount;
    public Integer numDecks;

    public DiscardPile(Integer nd) {
        numDecks=nd;

    }

    public void addCard(Card c) {
        dp.add(c);

    }

    public void determineCards() {
        runningCount=0;

        for (Card c : dp) {

            // face cards and 10
            if (c.rank >= 8) {
                runningCount-=1;
            }

            // elif implementation
            // aces
            else if (c.rank == 0) {
                //runningCount-=1;
                runningCount+=0;

            }

            //Number cards 2 through 6
            else if (c.rank>=1 && c.rank<=5){
                runningCount+=1;
            }

            //Cards 7,8,9 don't do anything to running count

            trueCount=runningCount/numDecks;


        }

    }
    public ArrayList getDiscardPile() {
        return dp;
    }

    public Integer getTrueCount() {
        return trueCount;
    }

    public void resetDiscardPile() {
        System.out.println("Discard Pile has been cleared");
        dp.clear();
    }

    public String toString() {
        return "Discard Pile: "+getDiscardPile();
    }
}
