package org.ht.rpg.game.utils;

import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public Boolean checkWinnerParty(Party parties){

  //Provaaaa
        return false;


    }
}
