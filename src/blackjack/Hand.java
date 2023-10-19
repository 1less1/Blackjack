package blackjack;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand {
    public ArrayList<Card> hand;

    public Integer handScore;

    public boolean ace;


    public Hand (Shoe s) {
        hand = new ArrayList<>();

        // Initializes deck with 2 cards drawn from a shuffled shoe
        s.shuffle();
        hitHand(s.drawCard());
        hitHand(s.drawCard());
    }


    public void calcHandScore() {
        handScore=0;

        for (Card c : hand) {
            // determine the point value for each card when we will start the game
            if (c.rank >= 9) {
                c.pointValue =10;
            }

            // elif implementation
            else if (c.rank==0) {
                ace=true;
                c.pointValue = 11;

            }

            else {
                    c.pointValue =(c.rank)+1;
            }

            handScore+=c.pointValue;

            if (ace && handScore>21) {
                handScore-=10;
            }
        }

    }

    public void hitHand(Card c) {
        hand.add(c);
        calcHandScore();

    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Integer getHandScore() {
        return handScore;
    }

    public void newHand() {
        hand.clear();
    }

    public Boolean checkBust(Integer handScore) {
        if (handScore > 21) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Current Hand: " + getHand() + "\nCurrent Score: " + getHandScore();
    }


}
