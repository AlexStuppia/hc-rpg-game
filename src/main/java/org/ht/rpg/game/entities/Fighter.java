package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;


public abstract class Fighter {

    //definisce se il personaggio puo conseguire il turno o meno
    private int id;
    private boolean isTurnoOk;
    private boolean isAlly;
    private int exp;
    private int level;
    private int velocita;
    private int lifePoints;
    private int armorPoints;
    private int manaPoints;
    private Attack attack;
    private Magic magic;
    private Consumable consumable;

    public Fighter() {
    }

    public Fighter(int id, boolean isTurnoOk, boolean isAlly, int exp, int level, int velocita, int lifePoints, int armorPoints, int manaPoints, Attack attack, Magic magic, Consumable consumable) {
        this.id = id;
        this.isTurnoOk = isTurnoOk;
        this.isAlly = isAlly;
        this.exp = exp;
        this.level = level;
        this.velocita = velocita;
        this.lifePoints = lifePoints;
        this.armorPoints = armorPoints;
        this.manaPoints = manaPoints;
        this.attack = attack;
        this.magic = magic;
        this.consumable = consumable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVelocita() {
        return velocita;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    public boolean isTurnoOk() {
        return isTurnoOk;
    }

    public void setTurnoOk(boolean turnoOk) {
        isTurnoOk = turnoOk;
    }

    public boolean isAlly() {
        return isAlly;
    }

    public void setAlly(boolean ally) {
        isAlly = ally;
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
