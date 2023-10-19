package blackjack;

public interface Player {
    boolean willHitHand();

    void hitter();

    void seeOpponentsCards(Hand h);

    void shoeWasReset(Integer shoeSize);



}
