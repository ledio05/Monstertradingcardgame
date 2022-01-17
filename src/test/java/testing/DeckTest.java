package testing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Card;
import project.Deck;
import project.Elementtype;
import project.Monstertype;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    List<Card> cards = new ArrayList<>();
    Deck deck;

    @BeforeEach
    void setUp() {
        cards.add(new Card("0","Blue Dragon",117, Monstertype.Dragon, Elementtype.Water));
        cards.add(new Card("1","Old Fire Elf",107,Monstertype.FireElf,Elementtype.Fire));
        cards.add(new Card("2","Green Goblin",87,Monstertype.Goblin,Elementtype.Normal));
        cards.add(new Card("3","Heavy Knight",120,Monstertype.Knight,Elementtype.Normal));
        cards.add(new Card("4","Deep Blue Kraken",140,Monstertype.Kraken,Elementtype.Water));
        cards.add(new Card("5","White Ork",98,Monstertype.Ork,Elementtype.Normal));
        cards.add(new Card("6","Dark Wizard",117,Monstertype.Wizard,Elementtype.Fire));
        cards.add(new Card("7","Blue Wave Spell",89,Monstertype.Spell,Elementtype.Water));
        cards.add(new Card("8","Red Fire Spell",100,Monstertype.Spell,Elementtype.Fire));
        cards.add(new Card("9","Normal Spell",100,Monstertype.Spell,Elementtype.Normal));
        cards.add(new Card("10","Red Dragon",123,Monstertype.Dragon,Elementtype.Fire));
        cards.add(new Card("11","Old Water Elf",106,Monstertype.FireElf,Elementtype.Water));
        cards.add(new Card("12","Dark Goblin",102,Monstertype.Goblin,Elementtype.Normal));
        cards.add(new Card("13","Strong Knight",119,Monstertype.Knight,Elementtype.Normal));
        cards.add(new Card("14","Deep Black Kraken",143,Monstertype.Kraken,Elementtype.Water));
        cards.add(new Card("15","Gray Ork",87,Monstertype.Ork,Elementtype.Normal));
        cards.add(new Card("16","White Wizard",110,Monstertype.Wizard,Elementtype.Normal));
        cards.add(new Card("17","Deep Ocean Spell",90,Monstertype.Spell,Elementtype.Water));
        cards.add(new Card("18","Flame Spell",112,Monstertype.Spell,Elementtype.Fire));
        cards.add(new Card("19","Normal Magic Spell",100,Monstertype.Spell,Elementtype.Normal));
        List<Card> tmp = new ArrayList<>();
        Card card1 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card1);
        tmp.add(card1);
        Card card2 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card2);
        tmp.add(card2);
        Card card3 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card3);
        tmp.add(card3);
        Card card4 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card4);
        tmp.add(card4);
        deck = new Deck(tmp);
    }

    @Test
    public void deck_size() {
        List<Card> tmp = new ArrayList<>();
        Card card1 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card1);
        tmp.add(card1);
        Card card2 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card2);
        tmp.add(card2);
        Card card3 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card3);
        tmp.add(card3);
        Card card4 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card4);
        tmp.add(card4);
        Card card5 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card5);
        tmp.add(card5);
        Deck deck1 = new Deck(tmp);
        assertEquals(4,deck1.getSize());
    }

    @Test
    public void deck_remove() {
        deck.removeCard(deck.getRandomCard());
        assertEquals(3,deck.getSize());
    }

    @Test
    public void deck_add() {
        Card card5 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card5);
        Card card6 = cards.get((int)(Math.random() * cards.size()));
        cards.remove(card6);

        deck.addCard(card5);
        deck.addCard(card6);
        //deck.addCard(cards.get((int)(Math.random() * cards.size())));
        assertEquals(6,deck.getSize());
        deck.removeCard(deck.getRandomCard());
        assertEquals(5,deck.getSize());
    }
}
