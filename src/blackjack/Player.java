package blackjack;

public interface Player {
    boolean willHitHand(Hand h);

    Hand seeOpponentsCards(Hand h);

    void shoeWasReset(Boolean r);

    String getName();
}

