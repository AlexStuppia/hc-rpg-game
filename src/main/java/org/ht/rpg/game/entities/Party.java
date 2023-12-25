package org.ht.rpg.game.entities;


import java.util.List;

public class Party {

    private List<Ally> allyList;
    private List<Enemy> enemyList;

    private List<Ally> deadAllyList;
    private List<Enemy> deadEnemyList;

    public Party() {
    }

    public List<Ally> getAllyList() {
        return allyList;
    }

    public void setAllyList(List<Ally> allyList) {
        this.allyList = allyList;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public List<Ally> getDeadAllyList() {
        return deadAllyList;
    }

    public void setDeadAllyList(List<Ally> deadAllyList) {
        this.deadAllyList = deadAllyList;
    }

    public List<Enemy> getDeadEnemyList() {
        return deadEnemyList;
    }

    public void setDeadEnemyList(List<Enemy> deadEnemyList) {
        this.deadEnemyList = deadEnemyList;
    }
}
