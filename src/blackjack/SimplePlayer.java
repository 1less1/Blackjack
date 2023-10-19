package blackjack;

public class SimplePlayer implements Player{

    public Hand hand;
    public Shoe shoe;

    public Boolean shoeReset;

    public SimplePlayer (Shoe s, Hand h) {
        hand=h;
        shoe=s;
    }



    @Override
    public boolean willHitHand() {
        if (hand.handScore>=17) {
            System.out.println("The player will stay :(");
            return false;
        }
        else {
            System.out.println("The player will hit!");
            return true;
        }
    }
    @Override
    public void hitter() {
        hand.hitHand(shoe.drawCard());
    }

    @Override
    public void seeOpponentsCards(Hand h) {

    }
    @Override
    public void shoeWasReset(Integer shoeSize) {
        if ((shoeSize%52)==0) {
            shoeReset = false;
        }
        else {
            shoeReset = true;
        }

    }
}
