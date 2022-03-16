//Clase carta
package main;

public class Card {
    private int num;
    private Suit suit;

    public Card(int n, Suit s){
        this.num=n;
        this.suit=s;
    }

    public int getNumCard() {
        return this.num;
    }

    public Suit getSuitCard() {
        return this.suit;
    }

    public String showCard(){
        return "Number " + this.num + " suit " + this.suit;
    }
}
