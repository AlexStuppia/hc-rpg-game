package org.ht.rpg.game.utils;

import org.ht.rpg.game.action.Action;
import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;
import org.ht.rpg.game.entities.*;
import org.ht.rpg.game.service.ActionService;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class CombatUtils {
    Scanner tastiera = new Scanner(System.in);
    public Tuple2<Boolean, Boolean> checkWinnerParty(Party parties) {
        Tuple2<Boolean, Boolean> isGameEndedIsPlayerWinner = new Tuple2<>(false, false);
        Set<Ally> setAlly = new HashSet<>(parties.getAllyList());
        Set<Enemy> setEnemy = new HashSet<>(parties.getEnemyList());

        if (setAlly.stream().allMatch(Ally::isDead)) {
            isGameEndedIsPlayerWinner.setFirst(true);
            isGameEndedIsPlayerWinner.setSecond(false);
            return isGameEndedIsPlayerWinner;
        } else if (setEnemy.stream().allMatch(Enemy::isDead)) {
            isGameEndedIsPlayerWinner.setFirst(true);
            isGameEndedIsPlayerWinner.setSecond(true);
            return isGameEndedIsPlayerWinner;
        } else {
            isGameEndedIsPlayerWinner.setFirst(false);
            isGameEndedIsPlayerWinner.setSecond(false);
            return isGameEndedIsPlayerWinner;
        }
    }

    public List<Choiche> makeAllPlayerChooseAction(Party parties) {
        tastiera = new Scanner(System.in);
        List<Choiche> choichesOfAllAlly = new ArrayList<>();
        int i = 0;
        while (i < parties.getAllyList().size()) {
            Ally member = parties.getAllyList().get(i);
            if (member.isDead() == true)
            {
                System.out.println(member.getName() + " è a terra e non puo fare nulla");
                i++;
            }
            else {
                System.out.println("what you want to do " + member.getName() + " ?");
                System.out.println("1 attack enemy ");
                System.out.println("2 use a magic ");
                System.out.println("3 use a item  ");
                System.out.println("4 run away");
                if (i != 0) {
                    System.out.println("0 go back to the previous pg");
                }
                int userInput = Integer.parseInt(tastiera.nextLine());
                switch (userInput) {
                    case 1: {
                        Action chosenAttack = selectAttack(member, "attack");
                        if (chosenAttack.getId() == 0) {
                            System.out.println("return to selection action");
                        } else {
                            List<Fighter> listOfTarget = selectTargets(parties, chosenAttack);
                            if (listOfTarget.stream().anyMatch(fighter -> fighter.getName().equals("return") == true)) {
                                System.out.println("return to selection actions");
                            } else {
                                Choiche singlechoiche = new Choiche(member, chosenAttack, listOfTarget,
                                        chosenAttack.getPriority(), chosenAttack.getPriorityLast());
                                choichesOfAllAlly.add(singlechoiche);
                                i++;
                            }
                        }
                        break;
                    }
                    case 2: {
                        Action chosenAttack = selectAttack(member, "magic");
                        if (chosenAttack.getId() == 0) {
                            System.out.println("return to selection action");
                        } else {
                            List<Fighter> listOfTarget = selectTargets(parties, chosenAttack);
                            if (listOfTarget.stream().anyMatch(fighter -> fighter.getName().equals("return") == true)) {
                                System.out.println("return to selection actions");
                            } else {
                                Choiche singlechoiche = new Choiche(member, chosenAttack, listOfTarget,
                                        chosenAttack.getPriority(), chosenAttack.getPriorityLast());
                                choichesOfAllAlly.add(singlechoiche);
                                i++;
                            }
                        }
                        break;
                    }
                    case 0: {
                        if (i == 0) {
                            System.out.println("wrong input");
                        } else {
                            i--;
                            choichesOfAllAlly.remove(i);
                        }
                        break;
                    }
                }
            }
        }
        return choichesOfAllAlly;
    }


    private Action selectAttack(Fighter member,String typeAttack) {
        // if member is an ally, scelta nostra
        // if is an enemy fare altro metodo con IA
        Action chosenAttack = null;
        Action discardAttack = new Attack(0, "discard", "utility", 10, 10, true, true, true,true,true, true, 1, true, true, true);
        if (typeAttack == "attack") {
            System.out.println("Select an attack:");
            System.out.println("Select 0 to go back to action selection");
            int contatore = 1;
            for (Action attack : member.getAttacks()) {
                System.out.println(contatore + ": " + attack.getName() + attack.getEffect());
                contatore++;
            }
            Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
            if (inputPlayer > 0 && inputPlayer <= member.getAttacks().size()) {
                chosenAttack = member.getAttacks().get(inputPlayer - 1);
            } else if (inputPlayer == 0) {
                System.out.println("go back to action selection");
                return discardAttack;
            } else {
                System.out.println("wrong input");
                System.out.println("go back to action selection");
                return discardAttack;
            }
        }
        else if (typeAttack == "magic"){
            System.out.println("Select a magic:");
            System.out.println("Select 0 to go back to action selection");
            int contatore = 1;
            for (Action magic : member.getMagics()) {
                System.out.println(contatore + ": " + magic.getName() + magic.getEffect());
                contatore++;
            }
            Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
            if (inputPlayer > 0 && inputPlayer <= member.getMagics().size()) {
                chosenAttack = member.getMagics().get(inputPlayer - 1);
            } else if (inputPlayer == 0) {
                System.out.println("go back to action selection");
                return discardAttack;
            } else {
                System.out.println("wrong input");
                System.out.println("go back to action selection");
                return discardAttack;
            }
        }
        return chosenAttack;
    }

    private List<Fighter> selectTargets(Party parties, Action chosenAttack) {
        List<Fighter> targets = new ArrayList<>();
        List <Attack> attackListProva = new ArrayList<>();
        List <Magic> magicListProva = new ArrayList<>();
        Consumable consumable = new Consumable();
        Fighter fighterForReturnInCaseOfWrongInput = new Ally(420,false,false,0,0,0,0,0,0,"return",attackListProva,magicListProva,consumable);
        System.out.println("Select a target:");
        if (chosenAttack.getHittingAllPlayer()) {
            System.out.println("this attack will target everyone on the field");
            System.out.println("1 if you are sure, 0 if you want go back");
            Integer userInput = Integer.parseInt(tastiera.nextLine());
            if (userInput == 1) {
                for (Ally ally : parties.getAllyList()) {
                    if(ally.isDead() == false){
                        targets.add(ally);
                    }
                }
                for (Enemy enemy : parties.getEnemyList()) {
                    if(enemy.isDead() == false){
                        targets.add(enemy);
                    }
                }
            } else {
                System.out.println("go back to selection");
                targets.add(fighterForReturnInCaseOfWrongInput);
            }
        } else if (chosenAttack.getHittingAllAlly()) {
            System.out.println("this attack will target all of your ally");
            System.out.println("1 if you are sure, 0 if you want go back");
            Integer userInput = Integer.parseInt(tastiera.nextLine());
            if (userInput == 1) {
                for (Ally ally : parties.getAllyList()) {
                    if(ally.isDead() == false){
                        targets.add(ally);
                    }
                }
            } else {
                System.out.println("go back to selection");
                targets.add(fighterForReturnInCaseOfWrongInput);
            }
        } else if (chosenAttack.getHittingAllEnemy()) {
            System.out.println("this attack will target all of the enemy");
            System.out.println("1 if you are sure, 0 if you want go back");
            Integer userInput = Integer.parseInt(tastiera.nextLine());
            if (userInput == 1) {
                for (Enemy enemy : parties.getEnemyList()) {
                    if(enemy.isDead() == false){
                        targets.add(enemy);
                    }
                }
            } else {
                System.out.println("go back to selection");
                targets.add(fighterForReturnInCaseOfWrongInput);
            }
        } else if (chosenAttack.getCanAttackMultiTarget()) {
            for (int i = 0; i < chosenAttack.getNumberOfTarget(); i++) {
                System.out.println("select " + chosenAttack.getNumberOfTarget() + " target");
                int contatore = 1;
                List<Enemy> tempEnemyList = new ArrayList<>();
                for (Enemy enemy : parties.getEnemyList())
                {
                    if (enemy.isDead()==false){
                        tempEnemyList.add(enemy);
                    }
                }
                for (Enemy enemy : tempEnemyList) {
                    System.out.println(contatore + ": " + enemy.getName() + " vita : " + enemy.getLifePoints());
                    contatore++;
                }
                Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
                if (inputPlayer > 0 && inputPlayer <= tempEnemyList.size()) {
                    targets.add(tempEnemyList.get(inputPlayer - 1));
                } else {
                    System.out.println("wrong input retry");
                    targets.add(fighterForReturnInCaseOfWrongInput);
                    break;
                }
            }
        } else if (chosenAttack.getCanAttackMultiTarget() == false && chosenAttack.getCanTargetAlly() == false) {
            int contatore = 1;
            List<Enemy> tempEnemyList = new ArrayList<>();
            for (Enemy enemy : parties.getEnemyList())
            {
                if (enemy.isDead()==false){
                    tempEnemyList.add(enemy);
                }
            }
            for (Enemy enemy : tempEnemyList) {
                System.out.println(contatore + ": " + enemy.getName() + " vita : " + enemy.getLifePoints());
                contatore++;
            }
            Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
            if (inputPlayer > 0 && inputPlayer <= tempEnemyList.size()) {
                targets.add(tempEnemyList.get(inputPlayer - 1));
            } else {
                System.out.println("wrong input retry");
                targets.add(fighterForReturnInCaseOfWrongInput);
            }
        } else if (chosenAttack.getCanTargetDeadAlly() == true) {
            int contatore = 1;
            List<Ally> tempAllyList = parties.getDeadAllyList();
            if (tempAllyList == null || tempAllyList.size() == 0)
            {
                System.out.println("no target available");
                targets.add(fighterForReturnInCaseOfWrongInput);
            }
            else {
                for (Ally ally : tempAllyList) {
                    System.out.println(contatore + ": " + ally.getName());
                    contatore++;
                }
                Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
                if (inputPlayer > 0 && inputPlayer <= tempAllyList.size()) {
                    targets.add(tempAllyList.get(inputPlayer - 1));
                } else {
                    System.out.println("wrong input retry");
                    targets.add(fighterForReturnInCaseOfWrongInput);
                }
            }
        }
        return targets;
    }


    public Map<Integer, Integer> calculateVelocity(Party parties, List<Choiche> fighterActions) {
        Map<Integer, Integer> mappaVelocita = new HashMap<>();
        for (Enemy enemy : parties.getEnemyList()) {
            mappaVelocita.put(enemy.getId(), enemy.getVelocity());
        }
        for (Ally ally : parties.getAllyList()) {
            mappaVelocita.put(ally.getId(), ally.getVelocity());
        }
        // Ordinare la mappa in base alla velocità in ordine decrescente
        List<Map.Entry<Integer, Integer>> sortedEntries = mappaVelocita.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        Map<Integer, Integer> orderedMap = calculatePriority(sortedEntries, fighterActions);

        return orderedMap;
    }

    private Map<Integer, Integer> calculatePriority(List<Map.Entry<Integer, Integer>> sortedEntries, List<Choiche> fighterActions) {
        Map<Integer, Integer> orderedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            orderedMap.put(entry.getKey(), entry.getValue());
        }

        for (Choiche choice : fighterActions) {
            if (choice.isActionPriority()) {
                if (orderedMap.containsKey(choice.getSender().getId())) {
                    Integer value = orderedMap.remove(choice.getSender().getId());
                    LinkedHashMap<Integer, Integer> tempMap = new LinkedHashMap<>();
                    tempMap.put(choice.getSender().getId(), value);
                    tempMap.putAll(orderedMap);
                    orderedMap = tempMap;
                }
            } else if (choice.isActionInversePriority()) {
                if (orderedMap.containsKey(choice.getSender().getId())) {
                    Integer value = orderedMap.remove(choice.getSender().getId());
                    orderedMap.put(choice.getSender().getId(), value); // Questo lo sposta alla fine
                }
            }
        }
        return orderedMap;
    }

    public Party makeCicleForActions(Party partiesAfterThisTurn, Map<Integer, Integer> velocityOrder, List<Choiche> choichesOfAll) {
        Party partyAfterThisAction = partiesAfterThisTurn;
        ActionService actionService = new ActionService();
        for (Map.Entry<Integer, Integer> entry : velocityOrder.entrySet()) {
            for (Choiche singleChoiche : choichesOfAll) {
                if (entry.getKey().equals(singleChoiche.getSender().getId()) && singleChoiche.getSender().isDead() == false) {
                        partyAfterThisAction = actionService.useAction(partyAfterThisAction, singleChoiche);
                }
                else if (entry.getKey().equals(singleChoiche.getSender().getId()) && singleChoiche.getSender().isDead() == false) {
                    System.out.println(singleChoiche.getSender().getName() + " is dead and cant'use the action");
                }
            }
        }
        System.out.println("porcodiooooo");
        return partyAfterThisAction;
    }

    public static Party checkPGdead(Party party, Fighter target) {
        if (target.getLifePoints() > 0)
        {
            System.out.println("vita dopo attacco " + target.getLifePoints());
        }
        else {
            if (target.isAlly() == false){
                System.out.println("il nemico "+ target.getName() + " è morto");
                target.setDead(true);
                party.getDeadEnemyList().add((Enemy) target);
            } else if (target.isAlly() == true) {
                System.out.println("l'alleato" + target.getName() + " è morto ");
                target.setDead(true);
                party.getDeadAllyList().add((Ally) target);
            }
        }
        return party;
    }
}


