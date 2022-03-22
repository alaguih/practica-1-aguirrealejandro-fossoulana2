//Clase carta
package main;

public class Card {
    private int num;
    private String suit;

    public Card(int n, String s){
        this.num=n;
        this.suit=s;
    }

    public int getNumCard() {
        return this.num;
    }

    public String getSuitCard() {
        return this.suit;
    }

    public String showCard(){
        return "Number " + this.num + " suit " + this.suit;
    }
}

