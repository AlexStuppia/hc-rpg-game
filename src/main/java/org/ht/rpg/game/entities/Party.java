package org.ht.rpg.game.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class Party {
   private List<Ally> allyList;
   private List<Enemy> enemyList;


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
}
