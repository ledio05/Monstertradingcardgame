package project;

import java.util.ArrayList;

public class Package {
    ArrayList<Card> cards = new ArrayList<Card>();

    final static int MAX_SIZE = 5;

    public Package(ArrayList<Card> cards){
        if(isValid()){
            this.cards=cards;
        }
        else{
            //User input doesnt have 5 cards
        }
    }
    public ArrayList<Card> getCards(){
        return cards;
    }

    public boolean isValid(){
        if(cards.size()==MAX_SIZE)
            return true;
        return false;
    }
}
