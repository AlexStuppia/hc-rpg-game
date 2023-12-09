package org.ht.rpg.game.utils;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.entities.*;

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
                    Attack chosenAttack = selectAttack(member);
                    if (chosenAttack.getId() == 0) {
                        System.out.println("return to selection action");
                    } else {
                        List<Integer> listOfTarget = selectTargets(parties, chosenAttack);
                        if (listOfTarget.contains(0)) {
                            System.out.println("return to selection actions");
                        } else {
                            Choiche singlechoiche = new Choiche(member.getId(), chosenAttack.getId(), listOfTarget,
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
        return choichesOfAllAlly;
    }


    private Attack selectAttack(Fighter member) {
        // if member is an ally, scelta nostra
        // if is an enemy fare altro metodo con IA
        Attack chosenAttack = null;
        Attack discardAttack = new Attack(0, "discard", "utility", 10, 10, true, true, true, true, 1, true, true, true);
        System.out.println("Select an attack:");
        System.out.println("Select 0 to go back to action selection");
        int contatore = 1;
        for (Attack attack : member.getAttacks()) {
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
        return chosenAttack;
    }

    private List<Integer> selectTargets(Party parties, Attack chosenAttack) {
        List<Integer> targets = new ArrayList<>();
        System.out.println("Select a target:");
        if (chosenAttack.getHittingAllPlayer()) {
            System.out.println("this attack will target everyone on the field");
            System.out.println("1 if you are sure, 0 if you want go back");
            Integer userInput = Integer.parseInt(tastiera.nextLine());
            if (userInput == 1) {
                for (Ally ally : parties.getAllyList()) {
                    targets.add(ally.getId());
                }
                for (Enemy enemy : parties.getEnemyList()) {
                    targets.add(enemy.getId());
                }
            } else {
                System.out.println("go back to selection");
                targets.add(0);
            }
        } else if (chosenAttack.getHittingAllAlly()) {
            for (Ally ally : parties.getAllyList()) {
                targets.add(ally.getId());
            }
        } else if (chosenAttack.getHittingAllEnemy()) {
            for (Enemy enemy : parties.getEnemyList()) {
                targets.add(enemy.getId());
            }
        } else if (chosenAttack.getCanAttackMultiTarget()) {
            for (int i = 0; i < chosenAttack.getNumberOfTarget(); i++) {
                System.out.println("select " + chosenAttack.getNumberOfTarget() + " target");
                int contatore = 1;
                List<Enemy> tempEnemyList = parties.getEnemyList();
                for (Enemy enemy : tempEnemyList) {
                    System.out.println(contatore + ": " + enemy.getId() + enemy.getLifePoints());
                    contatore++;
                }
                Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
                if (inputPlayer > 0 && inputPlayer <= tempEnemyList.size()) {
                    targets.add(tempEnemyList.get(inputPlayer - 1).getId());
                } else {
                    System.out.println("wrong input retry");
                    targets.add(0);
                    break;
                }
            }
        } else if (chosenAttack.getCanAttackMultiTarget() == false && chosenAttack.getCanTargetAlly() == false) {
            int contatore = 1;
            List<Enemy> tempEnemyList = parties.getEnemyList();
            for (Enemy enemy : tempEnemyList) {
                System.out.println(contatore + ": " + enemy.getId() + enemy.getLifePoints());
                contatore++;
            }
            Integer inputPlayer = Integer.parseInt(tastiera.nextLine());
            if (inputPlayer > 0 && inputPlayer <= tempEnemyList.size()) {
                targets.add(tempEnemyList.get(inputPlayer - 1).getId());
            } else {
                System.out.println("wrong input retry");
                targets.add(0);
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
                if (orderedMap.containsKey(choice.getIdSender())) {
                    Integer value = orderedMap.remove(choice.getIdSender());
                    LinkedHashMap<Integer, Integer> tempMap = new LinkedHashMap<>();
                    tempMap.put(choice.getIdSender(), value);
                    tempMap.putAll(orderedMap);
                    orderedMap = tempMap;
                }
            } else if (choice.isActionInversePriority()) {
                if (orderedMap.containsKey(choice.getIdSender())) {
                    Integer value = orderedMap.remove(choice.getIdSender());
                    orderedMap.put(choice.getIdSender(), value); // Questo lo sposta alla fine
                }
            }
        }
        return orderedMap;
    }

    public void makeActionsDO(Map<Integer, Integer> velocityOrder, List<Choiche> choichesOfAll) {
//        velocityOrder.entrySet().forEach(entry -> {
//            int temporaryid = entry.getKey();
//            choichesOfAll.get().getIdSender()
//        });


        // forse conviene che choiche invece di avere degli id e basta, riceva in pasto
        // proprio gli interi oggetti

        for (Choiche choice : choichesOfAll) {
            System.out.println("il pg con id " + choice.getIdSender() + " con la mossa " + choice.getIdAction() + " attachera " +
                    "" + choice.getListOfTargets());
        }
        System.out.println("");
        System.out.println("porcodiooooo");
    }
}


