//Clase
package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Table {
    private static Deque<Card> columnGolds;
    private static Deque<Card> columnCups;
    private static Deque<Card> columnSwords;
    private static Deque<Card> columnClubs;
    public Table(){
        //PRE:
        //POST:Creates the 4 empty structures with capacity of 10.
        columnGolds = new ArrayDeque<>(12);
        columnCups = new ArrayDeque<>(12);
        columnSwords = new ArrayDeque<>(12);
        columnClubs = new ArrayDeque<>(12);
        List<Deque<Card>> suits = new ArrayList<>();
        suits.add(columnGolds);
        suits.add(columnCups);
        suits.add(columnSwords);
        suits.add(columnClubs);
    }

    public static boolean canPlay(Card c){
        int n=c.getNumCard();
        Suit s=c.getSuitCard();
        if (n==5){
            return true;
        }
        if (s==Suit.Golds){
            if ((columnGolds.getFirst().getNumCard()==n-1) || (columnGolds.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        if (s==Suit.Swords){
            if ((columnSwords.getFirst().getNumCard()==n-1) || (columnSwords.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        if (s==Suit.Cups){
            if ((columnCups.getFirst().getNumCard()==n-1) || (columnCups.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        if (s==Suit.Clubs){
            if ((columnClubs.getFirst().getNumCard()==n-1) || (columnClubs.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean putCard(Card c){
        if (!canPlay(c)){
            return false;
        }
        int n=c.getNumCard();
        Suit s=c.getSuitCard();
        switch (s){
            case Golds:
                if (columnGolds.getFirst().getNumCard()==n-1){
                    columnGolds.addFirst(c);
                }
                else {
                    columnGolds.addLast(c);
                }
            case Swords:
                if (columnSwords.getFirst().getNumCard()==n-1){
                    columnSwords.addFirst(c);
                }
                else {
                    columnSwords.addLast(c);
                }
            case Cups:
                if (columnCups.getFirst().getNumCard()==n-1){
                    columnCups.addFirst(c);
                }
                else {
                    columnCups.addLast(c);
                }
            case Clubs:
                if (columnClubs.getFirst().getNumCard()==n-1){
                    columnClubs.addFirst(c);
                }
                else {
                    columnClubs.addLast(c);
                }
        }
        return true;
    }

    public String showTable(){
        String p1="";
        String p2="";
        String p3="";
        String p4="";
        Deque<Card> g= columnGolds;
        Deque<Card> s= columnSwords;
        Deque<Card> c1= columnCups;
        Deque<Card> c2= columnClubs;
        while(!g.isEmpty()){
            p1=p1+g.getFirst().showCard();
            g.removeFirst();
        }
        while(!s.isEmpty()){
            p2=p2+s.getFirst().showCard();
            s.removeFirst();
        }
        while(!c1.isEmpty()){
            p3=p3+c1.getFirst().showCard();
            c1.removeFirst();
        }
        while(!c2.isEmpty()){
            p4=p4+c2.getFirst().showCard();
            c2.removeFirst();
        }
        return "The column of golds has the cards: "+p1+" The column of Swords has the crads: "+p2+" The column of Cups has the crads: "+p3+" The column of Clubs has the crads: "+p4;
    }




}
