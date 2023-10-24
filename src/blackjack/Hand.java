package blackjack;

import java.util.ArrayList;

public class Hand {

    public Shoe shoe;
    public ArrayList<Card> hand;

    public Integer handScore;

    public boolean ace;
    public Integer numAces;


    public Hand (Shoe s) {
        hand = new ArrayList<>();
        // Initializes deck with 2 cards drawn from a shuffled shoe
        this.shoe=s;
        hitHand(shoe.drawCard());
        hitHand(shoe.drawCard());
    }


    public void calcHandScore() {
        handScore=0;
        ace=false;
        numAces=0;

        for (Card c : hand) {
            // determine the point value for each card when we will start the game
            if (c.rank >= 9) {
                c.pointValue =10;
            }

            // elif implementation
            else if (c.rank==0) {
                ace=true;
                numAces+=1;
                c.pointValue = 11;

            }

            else {
                    c.pointValue =(c.rank)+1;
            }

            handScore+=c.pointValue;

            if (ace && handScore>21) {
                handScore-=(10*numAces);
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
        hitHand(shoe.drawCard());
    }

    public Boolean noBust() {
        if (handScore <= 21) {
            return true;
        } else {
            System.out.println("Bust!");
            return false;
        }
    }

    public String toString() {
        return "Hand: " + getHand() + "\nScore: " + getHandScore();
    }


}
