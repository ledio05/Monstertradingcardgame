package project;



import lombok.Getter;
import project.Elementtype;
import project.Monstertype;

public class Card {

    @Getter
    private String id;

    @Getter
    private String name;

    @Getter
    private float damage;

    @Getter
    private Monstertype Monstertype;

    @Getter
    private Elementtype Elementtype;

    public Card() {

    }

    public Card(String id, String name, float damage) {
        this.id = id;
        this.name = name;
        this.damage = damage;
    }

    public Card(String id, String name, float damage,Monstertype type, Elementtype element) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        Monstertype = type;
        Elementtype = element;
    }
}