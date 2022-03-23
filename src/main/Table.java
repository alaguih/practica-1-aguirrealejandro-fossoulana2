//Clase
package main;

import java.util.*;

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
        //PRE:The table and the Card c have to be created.
        //POST:It will be returned true if the card c can be placed and false otherwise.
        int n=c.getNumCard();
        String s=c.getSuitCard();
        if (n==5){
            return true;
        }
        if (s=="golds"){
            if ((columnGolds.getFirst().getNumCard()==n-1) || (columnGolds.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        if (s=="swords"){
            if ((columnSwords.getFirst().getNumCard()==n-1) || (columnSwords.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        if (s=="cups"){
            if ((columnCups.getFirst().getNumCard()==n-1) || (columnCups.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        if (s=="clubs"){
            if ((columnClubs.getFirst().getNumCard()==n-1) || (columnClubs.getLast().getNumCard()==n+1)){
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean putCard(Card c){
        //PRE:The card c and the Desk have to be created.
        //POST:It will be returned true if the card is putted on the desk and false otherwise.
        if (!canPlay(c)){
            return false;
        }
        int n=c.getNumCard();
        String s=c.getSuitCard().toLowerCase(Locale.ROOT);
        switch (s){
            case "golds":
                if (columnGolds.getFirst().getNumCard()==n-1 || n==5){
                    columnGolds.addFirst(c);
                }
                else {
                    columnGolds.addLast(c);
                }
            case "swords":
                if (columnSwords.getFirst().getNumCard()==n-1 || n==5){
                    columnSwords.addFirst(c);
                }
                else {
                    columnSwords.addLast(c);
                }
            case "cups":
                if (columnCups.getFirst().getNumCard()==n-1 || n==5){
                    columnCups.addFirst(c);
                }
                else {
                    columnCups.addLast(c);
                }
            case "clubs":
                if (columnClubs.getFirst().getNumCard()==n-1 || n==5){
                    columnClubs.addFirst(c);
                }
                else {
                    columnClubs.addLast(c);
                }
        }
        return true;
    }

    public static String showTable(){
        //PRE:The Desk has to be created.
        //Post:It will be returned a String of the cards on the desk.
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

