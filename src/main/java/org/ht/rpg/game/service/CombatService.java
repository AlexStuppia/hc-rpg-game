package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;

import java.util.*;


public class CombatService {
    //@Autowired
    public void combattimento(Party parties){



        int turni = 0;
        Map<Integer,Integer> velocityOrder = calculateVelocity(parties);



        for (int i = 0; i < parties.getEnemyList().size(); i++) {
            int element = parties.getEnemyList().get(i).getExp();
            System.out.println("IL NEMICO esperienza " + element);
        }

  //      for (int i = 0; i < parties.getAlleati().size(); i++) {
  //          int element = parties.getAlleati().get(i).getExp();
  //          System.out.println("IL alleartp  esperienza" + element);
  //     }
    }
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

}

