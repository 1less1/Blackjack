package blackjack;

import java.util.ArrayList;

public class CountingPlayer implements Player{
    //Counts cards using simple Hi Lo method
    //This player is smarter since it will not bust as much since it is only taking risks based on the counts it has

    public String name;
    public boolean reset=false;

    public Hand opponentsHand;
    public DiscardPile dp;
    public Integer numDecks;
    

    public CountingPlayer(String n) {
        name=n;

    }

    @Override
    public boolean willHitHand(Hand h) {
        dp.determineCards();
        System.out.println(dp.getTrueCount());
        if (h.getHandScore()>=18) {
            return false;
        }

        else if (h.getHandScore() <= opponentsHand.getHandScore()) {
            //Base case to hit at a lower hand score than opponents initial hand
            if (dp.getTrueCount()>=1 && h.getHandScore()<=11) {
                //More face cards when true count is positive so hit if low hand score
                return true;
            }
            else if (dp.getTrueCount()<=-1 && h.getHandScore()<=17) {
                //Less face cards when true count is negative so hit if you have a medium to high hand score
               return true;
            }
            else if (dp.getTrueCount()>0 && h.getHandScore()>=16) {
                //More face cards when true count is positive so stay if hand score is getting high
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public void seeOpponentsCards(Hand h) {
        opponentsHand=h;
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
