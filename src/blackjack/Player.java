package blackjack;

import java.util.ArrayList;

public interface Player {
    boolean willHitHand(Hand h);

    void seeOpponentsCards(Hand h);

    void shoeWasReset(Boolean r);

    void seeDiscardPile(DiscardPile dp);

    String getName();
}

