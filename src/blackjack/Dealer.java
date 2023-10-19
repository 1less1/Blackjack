package blackjack;

public class Dealer implements Player{


    public Hand hand;
    public Shoe shoe;

    public Boolean shoeReset;
    public Dealer(Shoe s, Hand h) {
        hand=h;
        shoe=s;

    }
    @Override
    public boolean willHitHand() {
        return false;
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
