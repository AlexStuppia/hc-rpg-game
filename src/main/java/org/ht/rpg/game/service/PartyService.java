package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartyService {
    public Party initParty(Story story){
        AllyService allyService = new AllyService();
        EnemyService enemyService = new EnemyService();
        List<Ally> allyList =  allyService.createAllies();
        List<Enemy> enemyList = enemyService.createEnemy(story.getEnvironment());
        List<Ally> deadAllyList = new ArrayList<>();
        List<Enemy> deadEnemyList = new ArrayList<>();
        Party parties = new Party();
        parties.setAllyList(allyList);
        parties.setEnemyList(enemyList);
        parties.setDeadAllyList(deadAllyList);
        parties.setDeadEnemyList(deadEnemyList);
        //Feature22
        return parties;
    }




}
