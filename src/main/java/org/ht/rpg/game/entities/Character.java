package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;


public abstract class Character {

    //definisce se il personaggio puo conseguire il turno o meno
    private boolean isTurnoOk;
    private int exp;
    private int level;
    private int lifePoints;
    private int armorPoints;
    private int manaPoints;
    private Attack attack;
    private Magic magic;
    private Consumable consumable;

    public Character() {
    }

    public Character(boolean isTurnoOk, int exp, int level, int lifePoints, int armorPoints, int manaPoints, Attack attack, Magic magic, Consumable consumable) {
        this.isTurnoOk = isTurnoOk;
        this.exp = exp;
        this.level = level;
        this.lifePoints = lifePoints;
        this.armorPoints = armorPoints;
        this.manaPoints = manaPoints;
        this.attack = attack;
        this.magic = magic;
        this.consumable = consumable;
    }

    public boolean isTurnoOk() {
        return isTurnoOk;
    }

    public void setTurnoOk(boolean turnoOk) {
        isTurnoOk = turnoOk;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        this.magic = magic;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }
}
