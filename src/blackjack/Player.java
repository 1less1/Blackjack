package blackjack;

public interface Player {
    boolean willHitHand(Hand h);

    void seeOpponentsCards(Hand h);

    void shoeWasReset(Boolean r);

    String getName();
}

