package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Shoe implements Iterable<Card>{

    private Integer numDecks;
    private ArrayList<Card> shoe = new ArrayList<>();
    public Shoe(Integer nD) {
        numDecks = nD;

        resetShoe();

    }

    public void resetShoe() {
        shoe.clear();
        System.out.println("The shoe has been reset!");

        for (int i=0; i < numDecks; i++) {
            insertDeck();
        }

    }

    public void insertDeck() {
        for (int i =0; i<52; i++) {
            shoe.add(new Card(i));
        }
    }

    public Card drawCard() {
        return shoe.remove(shoe.size()-1);
    }

    public void shuffle() {
        Collections.shuffle(shoe);

    }

    public Iterator<Card> iterator() {
        return shoe.iterator();
    }

    public ArrayList getShoe() {
        return shoe;
    }

    public Integer getShoeSize() {
        return shoe.size();
    }
}
