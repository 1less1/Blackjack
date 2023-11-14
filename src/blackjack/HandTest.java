package blackjack;

import org.junit.Test;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {

    Integer numDecks=2;
   private DiscardPile dp;
   private Shoe shoe;

   private Hand hand;

   Card ace = new Card(0);
   Card face = new Card(9);

   @Before
   public void setUp() {
       dp = new DiscardPile(numDecks);
       shoe = new Shoe(numDecks, dp);

       hand = new Hand(shoe);
   }


    @Test
    public void testHand() {
        //Test if clear hand actually clears the hand
        hand.clearHand();
        ArrayList emptyList = new ArrayList<>();

        assertEquals(emptyList, hand.getHand());


        //Test if an ace will be valued at 11 if there is no chance for a bust
        hand.hitHand(ace);
        assertEquals(11, (int) hand.getHandScore());

        //Test if the 2nd ace will count as 1 to the total score so there is no chance for a bust
        hand.hitHand(ace);
        assertEquals(12, (int) hand.getHandScore());

        //Test to see if the two aces will turn to a value of one in order to save the hand from busting
        hand.hitHand(face);
        assertEquals(12, (int) hand.getHandScore());

        //Test to see if the hand will return false if its score yields a bust
        hand.hitHand(face);
        assertFalse(hand.noBust());

        //Test to see if new hand will clear and then draw 2 cards. I am going to compare the hand to an empty list to make sure it has cards.
        hand.newHand();
        assertFalse(hand.getHand()==emptyList);

    }


    @Test
    public void testWillHitHand() {
        hand.clearHand();
        AtlanticCityDealer andy = new AtlanticCityDealer("Andy");

        //Test to see if true is returned when the hand score us under 17 and has not busted
        hand.hitHand(face);
        assertTrue(andy.willHitHand(hand));

        //Test to see if false is returned when the hand score is above 17 and has not busted
        hand.hitHand(face);
        assertFalse(andy.willHitHand(hand));

    }
}
