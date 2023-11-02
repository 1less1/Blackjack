package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Shoe implements Iterable<Card>{

    private Integer numDecks;
    private ArrayList<Card> shoe = new ArrayList<>();

    private DiscardPile discardPile;


    // Extra credit: create an extra list as the discard pile. Use it to have the computer "count cards"
    public Shoe(Integer nD, DiscardPile dp) {
        numDecks = nD;
        resetShoe();
        discardPile=dp;
    }

    public void resetShoe() {
        shoe.clear();
        System.out.println("The shoe has been reset with "+numDecks+" decks!");

        for (int i=0; i < numDecks; i++) {
            insertDeck();
        }
        shuffle();

    }

    public void insertDeck() {
        for (int i =0; i<52; i++) {
            shoe.add(new Card(i));
        }
    }

    public Card drawCard() {
        Card c = shoe.remove(shoe.size()-1);
        discardPile.addCard(c); //Add drawn card to discard pile
        return c;

    }

    public void shuffle() {
        Collections.shuffle(shoe);
        System.out.println("Shoe has been shuffled!");
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
