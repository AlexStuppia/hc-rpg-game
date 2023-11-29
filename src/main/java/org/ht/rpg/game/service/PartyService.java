package org.ht.rpg.game.service;


import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyService {
    public Party initEntities() {
        List<Ally> allyList = new ArrayList<>();
        List<Enemy> enemyList = new ArrayList<>();
        Party party = new Party();
        Enemy enemy = new Enemy();
        Ally ally = new Ally();

        allyList.add(ally);
        enemyList.add(enemy);

        party.setAllyList(allyList);
        party.setEnemyList(enemyList);


        return party;
    }


}
