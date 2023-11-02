package blackjack;

public class TestDriver {

    public static void main (String[] args) {
        DiscardPile dp = new DiscardPile(1);
        System.out.println(dp);
        Shoe s = new Shoe(1,dp);
        Hand h = new Hand(s);
        System.out.println(h);
        System.out.println();

        // Test ace functionality
        Card ace1 = new Card(0);
        Card ace2 = new Card(0);
        Card face =  new Card(10);
        h.newHand();
        //h.hitHand(ace1);
        //h.hitHand(face);

        h.hitHand(s.drawCard());
        h.hitHand(s.drawCard());

        System.out.println(h);

        System.out.println(dp);
        dp.determineCards();
        System.out.println(dp.getTrueCount());



    }
}
