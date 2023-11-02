package blackjack;

import java.util.ArrayList;

public class Dealer implements Player{

    public String name;
    public boolean reset=false;

    public Hand opponentsHand;
    public DiscardPile dp;

    public Dealer(String n) {
        name=n;
    }

    @Override
    public boolean willHitHand(Hand h) {
        if (h.getHandScore()>=opponentsHand.getHandScore()) {
            //System.out.println(name+" will stay :(");
            return false;
        }
        else {
            //System.out.println(name+" will hit!");
            return true;
        }
    }

    @Override
    public void seeOpponentsCards(Hand h) {
        opponentsHand=h;
        //return h;
    }

    @Override
    public void seeDiscardPile(DiscardPile dp) {
        this.dp=dp;
    }


    @Override
    public void shoeWasReset(Boolean r) {
        if (r) {
            reset=true;
        } else {
            reset=false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
