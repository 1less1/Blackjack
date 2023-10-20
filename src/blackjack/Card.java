package blackjack;

public class Card {

    private static final String[] suits ={"Spades", "Hearts", "Diamonds", "Clubs"};

    private static final String[] ranks = {"Ace", "2", "3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public Integer cardValue;

    public Integer suit;

    public Integer rank;

    public Integer pointValue;

    public Card(Integer value) {

        cardValue=value;
        rank=cardValue%13;
        suit=cardValue/13;

    }

    public Integer getRank() {
        return rank;
    }

    public Integer getSuit() {
        return suit;
    }

    public Integer getCardValue() {
        return cardValue;
    }

    public Integer getPointValue() {
        return pointValue;
    }

    // this function sets this object to be in the following representation every time you want to print

    public String toString() {
        return ranks[getRank()] + " of " + suits[getSuit()];
    }


    /*public boolean equals(Card c) {
        return c.cardValue == this.cardValue;
    }
    */
}
