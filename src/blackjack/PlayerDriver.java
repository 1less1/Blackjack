package blackjack;

public class PlayerDriver {

    public static void main(String args[]) {
        Shoe s = new Shoe(2);
        Hand h = new Hand(s);
        SimplePlayer dom = new SimplePlayer(s,h);

        while (dom.willHitHand()) {
            dom.hitter();
            System.out.println(h);
        }

    }
}
