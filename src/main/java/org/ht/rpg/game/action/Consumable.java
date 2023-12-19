package org.ht.rpg.game.action;

public class Consumable extends Action{
    int id;
    String name;
    String effect;
    int quantity;

    public Consumable() {
    }

    public Consumable(int id, String name, String effect, int quantity) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
