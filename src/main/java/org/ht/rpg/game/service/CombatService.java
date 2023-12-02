package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.utils.CombatUtils;

import java.util.*;


public class CombatService {
    //@Autowired
    public void startCombat(Party parties) {


        int turni = 0;
        CombatUtils combatUtils = new CombatUtils();
        Boolean endFight = combatUtils.checkWinnerParty(parties);

        Map<Integer, Integer> velocityOrder = combatUtils.calculateVelocity(parties);


        for (int i = 0; i < parties.getEnemyList().size(); i++) {
            int element = parties.getEnemyList().get(i).getExp();
            System.out.println("IL NEMICO esperienza " + element);
        }

        //      for (int i = 0; i < parties.getAlleati().size(); i++) {
        //          int element = parties.getAlleati().get(i).getExp();
        //          System.out.println("IL alleartp  esperienza" + element);
        //     }
    }
}

