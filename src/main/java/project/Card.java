package project;


public abstract class Card {

    protected String name;
    protected int damage;
    protected Elementtype elementtype;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Elementtype getElementtype() {
        return elementtype;
    }

    public void setElementtype(Elementtype elementtype) {
        this.elementtype = elementtype;
    }

    public abstract int getID();
}
