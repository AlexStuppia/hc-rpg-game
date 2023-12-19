package org.ht.rpg.game.action;

public abstract class Action {


    int id;
    String name;
    String effect;
    int quantity;
    int damage;
    Boolean isPriority;
    Boolean isPriorityLast;

    Boolean canTargetAlly;
    Boolean canAttackMultiTarget;

    Integer numberOfTarget;
    Boolean isHittingAllEnemy;
    Boolean isHittingAllAlly;
    Boolean isHittingAllPlayer;

    public Action() {
    }

    public Action(int id, String name, String effect, int quantity, int damage, Boolean isPriority, Boolean isPriorityLast, Boolean canTargetAlly, Boolean canAttackMultiTarget, Integer numberOfTarget, Boolean isHittingAllEnemy, Boolean isHittingAllAlly, Boolean isHittingAllPlayer) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.quantity = quantity;
        this.damage = damage;
        this.isPriority = isPriority;
        this.isPriorityLast = isPriorityLast;
        this.canTargetAlly = canTargetAlly;
        this.canAttackMultiTarget = canAttackMultiTarget;
        this.numberOfTarget = numberOfTarget;
        this.isHittingAllEnemy = isHittingAllEnemy;
        this.isHittingAllAlly = isHittingAllAlly;
        this.isHittingAllPlayer = isHittingAllPlayer;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Boolean getPriority() {
        return isPriority;
    }

    public void setPriority(Boolean priority) {
        isPriority = priority;
    }

    public Boolean getPriorityLast() {
        return isPriorityLast;
    }

    public void setPriorityLast(Boolean priorityLast) {
        isPriorityLast = priorityLast;
    }

    public Boolean getCanTargetAlly() {
        return canTargetAlly;
    }

    public void setCanTargetAlly(Boolean canTargetAlly) {
        this.canTargetAlly = canTargetAlly;
    }

    public Boolean getCanAttackMultiTarget() {
        return canAttackMultiTarget;
    }

    public void setCanAttackMultiTarget(Boolean canAttackMultiTarget) {
        this.canAttackMultiTarget = canAttackMultiTarget;
    }

    public Integer getNumberOfTarget() {
        return numberOfTarget;
    }

    public void setNumberOfTarget(Integer numberOfTarget) {
        this.numberOfTarget = numberOfTarget;
    }

    public Boolean getHittingAllEnemy() {
        return isHittingAllEnemy;
    }

    public void setHittingAllEnemy(Boolean hittingAllEnemy) {
        isHittingAllEnemy = hittingAllEnemy;
    }

    public Boolean getHittingAllAlly() {
        return isHittingAllAlly;
    }

    public void setHittingAllAlly(Boolean hittingAllAlly) {
        isHittingAllAlly = hittingAllAlly;
    }

    public Boolean getHittingAllPlayer() {
        return isHittingAllPlayer;
    }

    public void setHittingAllPlayer(Boolean hittingAllPlayer) {
        isHittingAllPlayer = hittingAllPlayer;

    }
}
