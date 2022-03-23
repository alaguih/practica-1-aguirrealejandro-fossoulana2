package main;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Playerh extends Player {

    public Playerh(String n, ArrayList<Card> c){
        super(n,c);
    }

    public Card playCard(Table t){
        if (!this.canPlay()){
            System.out.println("You can´t play any of your cards.");
            return null;
        }
        else{
            System.out.println("Choose the card that you´d play");
            System.out.println("Write the suit of the card that you´s chosen: ");
            Scanner entrada=new Scanner(System.in);
            String s=entrada.nextLine();
            s.toLowerCase(Locale.ROOT);
            System.out.println("Write the number of the card that you´s chosen: ");
            Scanner entrada1=new Scanner(System.in);
            int n=entrada1.nextInt();
            Card c=new Card(n,s);
            if (!t.canPlay(c)){
                System.out.println("That card can´t be played, choose another");
                this.playCard();
            }
            else{
                return c;
            }
        }

    }
}
