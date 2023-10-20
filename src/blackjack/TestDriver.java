package blackjack;

public class TestDriver {

    public static void main (String[] args) {
        Shoe s = new Shoe(1);

        Hand h = new Hand(s);

        System.out.println(h);
        System.out.println();

        // Test ace functionality
        Card ace1 = new Card(0);
        Card ace2 = new Card(0);
        Card face =  new Card(10);
        h.newHand();
        h.hitHand(ace1);
        h.hitHand(face);

        System.out.println(h);

        h.hitHand(ace2);

        System.out.println(h);



    }
}
