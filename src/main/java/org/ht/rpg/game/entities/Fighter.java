package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;

import java.util.List;
import java.util.Objects;


public abstract class Fighter {

    //definisce se il personaggio puo conseguire il turno o meno
    private int id;
    private boolean isTurnoOk;
    private boolean isAlly;
    private int exp;
    private int level;
    private int velocity;
    private int lifePoints;
    private int armorPoints;
    private int manaPoints;

    private String name;
    private List<Attack> attacks;
    private List<Magic> magics;
    private Consumable consumable;

    private boolean isDead;
    private boolean isPoisoned;

    private boolean isImmunePoisoned;
    private boolean isLit; //Burned
    private boolean isImmuneLitting;
    private boolean isCursed;
    private boolean isImmuneCursing;
    private boolean isScared;
    private boolean isImmuneToScare;

    public Fighter() {
    }

    public Fighter(int id, int velocity) {
        this.id = id;
        this.velocity = velocity;
    }

    public Fighter(int id, boolean isTurnoOk, boolean isAlly, int exp, int level, int velocity, int lifePoints, int armorPoints, int manaPoints,String name, List<Attack> attacks, List<Magic> magics, Consumable consumable) {
        this.id = id;
        this.isTurnoOk = isTurnoOk;
        this.isAlly = isAlly;
        this.exp = exp;
        this.level = level;
        this.velocity = velocity;
        this.lifePoints = lifePoints;
        this.armorPoints = armorPoints;
        this.manaPoints = manaPoints;
        this.name = name;
        this.attacks = attacks;
        this.magics = magics;
        this.consumable = consumable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttack(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<Magic> getMagics() {
        return magics;
    }

    public void setMagic(List<Magic> magics) {
        this.magics = magics;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }

    public boolean isImmunePoisoned() {
        return isImmunePoisoned;
    }

    public void setImmunePoisoned(boolean immunePoisoned) {
        isImmunePoisoned = immunePoisoned;
    }

    public boolean isLit() {
        return isLit;
    }

    public void setLit(boolean lit) {
        isLit = lit;
    }

    public boolean isImmuneLitting() {
        return isImmuneLitting;
    }

    public void setImmuneLitting(boolean immuneLitting) {
        isImmuneLitting = immuneLitting;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public void setCursed(boolean cursed) {
        isCursed = cursed;
    }

    public boolean isImmuneCursing() {
        return isImmuneCursing;
    }

    public void setImmuneCursing(boolean immuneCursing) {
        isImmuneCursing = immuneCursing;
    }

    public boolean isScared() {
        return isScared;
    }

    public void setScared(boolean scared) {
        isScared = scared;
    }

    public boolean isImmuneToScare() {
        return isImmuneToScare;
    }

    public void setImmuneToScare(boolean immuneToScare) {
        isImmuneToScare = immuneToScare;
    }


    // TODO CONTROLLARE SE QUESTI 2 METODI SIANO CORRETTI O MENO

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return Objects.equals(id, fighter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
