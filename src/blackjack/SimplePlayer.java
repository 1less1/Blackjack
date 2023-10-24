package blackjack;

import java.util.Locale;

public class SimplePlayer implements Player{

    public String name;
    public boolean reset=false;

    public Hand opponentsHand;

    public SimplePlayer(String n) {
        name=n;
    }

    @Override
    public boolean willHitHand(Hand h) {
        if (h.getHandScore()>=17) {
            //System.out.println(name+" will stay :(");
            return false;
        }
        else {
            //System.out.println(name+" will hit!");
            return true;
        }
        // have this return true probably then call a hitter
    }

    @Override
    public Hand seeOpponentsCards(Hand h) {
        opponentsHand=h;
        return h;
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
