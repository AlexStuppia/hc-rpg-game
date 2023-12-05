package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.utils.CombatUtils;
import org.ht.rpg.game.utils.Tuple2;

import java.util.*;


public class CombatService {
    //@Autowired
    public void startCombat(Party parties) {
        //tuple creata per comodità, il primo booleano indica se lo scontro è terminato o meno
        //ossia quando uno dei 2 party è morto, il secondo booleano indica il party vincente
        //se è true ha vinto l'utente, se è falso, ha vinto il computer ed hai perso.
        Tuple2<Boolean,Boolean> isGameEndedIsPlayerWinner = new Tuple2<>(false,false);
        int turni = 0;
        CombatUtils combatUtils = new CombatUtils();
        while(isGameEndedIsPlayerWinner.getFirst()==false){
            isGameEndedIsPlayerWinner = combatUtils.checkWinnerParty(parties);
            if (isGameEndedIsPlayerWinner.getFirst()==false)
            {
                System.out.println("bloccato in the loop");
                Map<Integer, Integer> velocityOrder = combatUtils.calculateVelocity(parties);

            } else if (isGameEndedIsPlayerWinner.getFirst()==true && isGameEndedIsPlayerWinner.getSecond()==false) {
                //hai perso
            }
            else if (isGameEndedIsPlayerWinner.getFirst()==true && isGameEndedIsPlayerWinner.getFirst()==true){
                // hai vinto
            }
        }




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

