package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.entities.Choiche;
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
        int turns = 0;
        CombatUtils combatUtils = new CombatUtils();
        Party partiesAfterThisTurn = parties;
        while(isGameEndedIsPlayerWinner.getFirst()==false){
            isGameEndedIsPlayerWinner = combatUtils.checkWinnerParty(parties);
            if (isGameEndedIsPlayerWinner.getFirst()==false)
            {
                List<Choiche> choicesOfAll = combatUtils.makeAllPlayerChooseAction(parties);
                Map<Integer, Integer> velocityOrder = combatUtils.calculateVelocity(parties,choicesOfAll);
                partiesAfterThisTurn = combatUtils.makeCicleForActions(partiesAfterThisTurn,velocityOrder,choicesOfAll);
            } else if (isGameEndedIsPlayerWinner.getFirst()==true && isGameEndedIsPlayerWinner.getSecond()==false) {
                //hai perso
                System.out.println("hai perso");
            }
            else if (isGameEndedIsPlayerWinner.getFirst()==true && isGameEndedIsPlayerWinner.getFirst()==true){
                // hai vinto
                System.out.println("hai vinto");
            }
        }




        for (int i = 0; i < parties.getEnemyList().size(); i++) {
            int element = parties.getEnemyList().get(i).getExp();
            System.out.println("IL NEMICO esperienza " + element);
        }
    }
}

