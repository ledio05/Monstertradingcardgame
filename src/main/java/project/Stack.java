package project;

import java.util.ArrayList;
import java.util.List;

public class Stack {

        private List<Card> cards = new ArrayList<Card>();

        public List<Card> getCards() {
                return cards;
        }

        public void setCards(List<Card> cards) {
                this.cards = cards;
        }

        public Stack(List<Card> cards){
                this.cards = cards;
        }

        public void addCard(Card card){
                cards.add(card);

        }

        public void removeCard(Card card){
                cards.remove(card);

        }


}
