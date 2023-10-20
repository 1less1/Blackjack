package blackjack;

public class SimplePlayer implements Player{


    public Hand hand;
    public Shoe shoe;

    public String name;

    public Boolean shoeReset;

    public SimplePlayer(String n, Shoe s, Hand h) {
        name=n;
        shoe=s;
        hand=h;
    }

    @Override
    public boolean willHitHand() {
        if (hand.handScore>=17) {
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
        hand.hitHand(shoe.drawCard());
    }

    @Override
    public void seeOpponentsCards(Hand h) {
        System.out.println("Last Game Opponent's "+h);

    }
    @Override
    public void shoeWasReset(Integer decks) {

    }

    @Override
    public String getName() {
        return name;
    }
}
