//Clase deck
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck{
    private ArrayList<Card> baraja;
    public Deck(){
        //PRE:
        //POST: it is created an ordered deck of cards.
        int i=0;
        while(i<48){
            int j=1;
            while(j<=12){
                baraja.add(new Card(j,Suit.Golds));
                j++;
                i++;
            }
            j=1;
            while(j<=12){
                baraja.add(new Card(j,Suit.Swords));
                j++;
                i++;
            }
            j=1;
            while(j<=12){
                baraja.add(new Card(j,Suit.Clubs));
                j++;
                i++;
            }
            j=1;
            while(j<=12){
                baraja.add(new Card(j,Suit.Cups));
                j++;
                i++;
            }
        }
    }
    public void shuffle(){
        //PRE: The deck of cards has to be created.
        //POST: The deck of cards will be shuffled.
        Random r = new Random();
        int k=0;
        while (k<40){
            int i = r.nextInt(48);
            int j = r.nextInt(48);
            Card c=baraja.get(i);
            baraja.set(i,baraja.get(j));
            baraja.set(j,c);
            k++;
        }
    }
    public Card getCard(){
        //PRE: The deck of cards has to be created.
        //POST: It is returned the last card of the deck.
        Card c=baraja.get(baraja.size());
        baraja.remove(baraja.size());
        return c;
    }
    public int cardsLeft(){
        //PRE: The deck has to be created.
        //POST: It will be returned true id the deck is empty and false otherwise.
        return baraja.size();
    }
    public void cut(int i){
        //PRE: The deck has to be created and i<=baraja.size().
        //POST: The deck will be cutted by the card i.
        List<Card> b1=baraja.subList(i,baraja.size());
        List<Card> b2=baraja.subList(0,i);
        baraja.clear();
        int j=0;
        while (j<i){
            baraja.add(b2.get(j));
            j++;
        }
        while (j<baraja.size()){
            baraja.add(b1.get(j));
            j++;
        }
    }


}
