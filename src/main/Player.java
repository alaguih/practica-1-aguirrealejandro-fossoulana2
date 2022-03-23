//Clase
package main;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Card> cards;

    public Player(String n, ArrayList<Card> c){
        this.name=n;
        this.cards=c;
    }

    public boolean canPlay(){
        int i=0;
        while (i<this.cards.size()){
            if (Table.canPlay(this.cards.get(i))){
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean haveCard(Card c){
        int i=0;
        while (i<this.cards.size()){
            if (this.cards.get(i)==c){
                return true;
            }
            i++;
        }
        return false;
    }

    public int cardsLeft(){
        return this.cards.size();
    }

    public boolean finish(){
        return this.cards.isEmpty();
    }

    public String showCards(){
        String s="";
        int i=0;
        while(i<this.cards.size()){
            s=s+this.cards.get(i).showCard();
            i++;
        }
        return s;
    }

    public void getCard(Card c){
        this.cards.add(c);
    }

    public ArrayList<Card> hand(){
        return this.cards;
    }

    public abstract Card playCard();


}

