package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.*;
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
                showSituationAtTheBegginingOftheTurn(turns,parties);
                List<Choiche> choicesOfAll = combatUtils.makeAllPlayerChooseAction(parties);
                Map<Integer, Integer> velocityOrder = combatUtils.calculateVelocity(parties,choicesOfAll);
                partiesAfterThisTurn = combatUtils.makeCicleForActions(partiesAfterThisTurn,velocityOrder,choicesOfAll);
                turns++;
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

    private void showSituationAtTheBegginingOftheTurn(int turns, Party parties) {
        if (turns == 0){
            System.out.println("è iniziata la battaglia");
        }
        System.out.println("questo è il [" + (turns + 1 ) + "] turno");
        System.out.println("i tuoi alleati sono");
        for (Ally ally : parties.getAllyList()){
            if (ally.isDead() == true) {
                System.out.println(ally.getName() + " è collasato");
            }
            else {
                System.out.println(ally.getName() + " PV : " + ally.getLifePoints());
            }
        }
        System.out.println("i tuoi nemici sono");
        for (Enemy enemy : parties.getEnemyList()){
            if (enemy.isDead() == true) {
                System.out.println(enemy.getName() + " è schiattato");
            }
            else {
                System.out.println(enemy.getName() + " PV : " + enemy.getLifePoints());
            }
        }
    }
}

