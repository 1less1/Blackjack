package blackjack;

import java.util.ArrayList;

public class Hand {

    public Shoe shoe;
    public ArrayList<Card> hand;

    public Integer handScore;

    public Hand (Shoe s) {
        hand = new ArrayList<>();
        // Initializes deck with 2 cards drawn from a shuffled shoe
        this.shoe=s;
        newHand();
    }


    public void calcHandScore() {
        handScore=0;
        Boolean ace=false;
        Integer numAces=0;

        for (Card c : hand) {
            // determine the point value for each card when we will start the game

            // face cards
            if (c.rank >= 9) {
                c.pointValue = 10;
            }

            // elif implementation
            // aces
            else if (c.rank==0) {
                c.pointValue = 11;
                ace=true;
                numAces+=1;

            }

            // number cards
            else {
                c.pointValue =(c.rank)+1;
            }

           handScore+=c.pointValue;
        }

        // check for aces and convert them to a score of "1" from 11 if the
        // hand score is exceeding 21
        if (ace && handScore>21) {
            handScore-=(10*numAces);
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
        // draw 2 cards
        hitHand(shoe.drawCard());
        hitHand(shoe.drawCard());
    }

    public Boolean noBust() {
        if (handScore <= 21) {
            return true;
        } else {
            //System.out.println("Bust!");
            return false;
        }
    }

    public String toString() {
        return "Hand: " + getHand() + "\nScore: " + getHandScore();
    }

}
