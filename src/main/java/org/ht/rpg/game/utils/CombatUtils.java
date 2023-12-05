package org.ht.rpg.game.utils;

import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;

import java.util.*;

public class CombatUtils {
    public Map<Integer, Integer> calculateVelocity(Party parties){
        Map<Integer, Integer> mappaVelocita = new HashMap<>();
        for (Enemy nemico : parties.getEnemyList()) {
            mappaVelocita.put(nemico.getId(), nemico.getVelocita());
        }
        for (Ally alleato : parties.getAllyList()) {
            mappaVelocita.put(alleato.getId(), alleato.getVelocita());
        }

        // Ordinare la mappa in base alla velocità in ordine decrescente
        Map<Integer, Integer> mappaOrdinata = new LinkedHashMap<>();
        mappaVelocita.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> mappaOrdinata.put(entry.getKey(), entry.getValue()));

        return mappaOrdinata;
    }


    public Tuple2<Boolean,Boolean> checkWinnerParty(Party parties){
        Tuple2<Boolean,Boolean> isGameEndedIsPlayerWinner = new Tuple2<>(false,false);
        Set<Ally> setAlly = new HashSet<>(parties.getAllyList());
        Set<Enemy> setEnemy = new HashSet<>(parties.getEnemyList());

        if(setAlly.stream().allMatch(Ally::isDead)) {
            isGameEndedIsPlayerWinner.setFirst(true);
            isGameEndedIsPlayerWinner.setSecond(false);
            return isGameEndedIsPlayerWinner;
        }
        else if(setEnemy.stream().allMatch(Enemy::isDead)) {
            isGameEndedIsPlayerWinner.setFirst(true);
            isGameEndedIsPlayerWinner.setSecond(true);
            return isGameEndedIsPlayerWinner;
        }
        else {
            isGameEndedIsPlayerWinner.setFirst(false);
            isGameEndedIsPlayerWinner.setSecond(false);
            return isGameEndedIsPlayerWinner;
        }
    }
}
