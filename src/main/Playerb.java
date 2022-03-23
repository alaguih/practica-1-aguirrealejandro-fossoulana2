package main;

import java.util.ArrayList;

public class Playerb extends Player{

    public Playerb(String n, ArrayList<Card> c){
        super(n,c);
    }

    public Card playCard(Table t){
        if (!this.canPlay()){
            System.out.println("You can´t play any of your cards.");
            return null;
        }
        ArrayList<Card> h=this.hand();
        int i=0;
        while(i<h.size()){
            if (t.canPlay(h.get(i))){
                return h.get(i);
            }
            i++;
        }
        return null;
    }
}
