package blackjack;

public class Dealer implements Player{


    public Hand dealerHand;
    public Hand oppHand;
    public Shoe shoe;

    public String name;

    public Boolean shoeReset;
    public Dealer(String n, Shoe s, Hand dh, Hand oh ) {
        dealerHand = dh;
        oppHand=oh;
        shoe=s;
        name=n;

    }
    @Override
    public boolean willHitHand(){
        if (dealerHand.handScore>=oppHand.handScore) {
            System.out.println(name+" will stay :(");
            return false;
        }
        else {
            System.out.println(name+" will hit!");
            return true;
        }
    }

    @Override
    public void hitter() {
        dealerHand.hitHand(shoe.drawCard());
    }

    @Override
    public void seeOpponentsCards(Hand h) {

    }

    @Override
    public void shoeWasReset(Integer shoeSize) {
    }

    @Override
    public String getName() {
        return name;
    }
}
