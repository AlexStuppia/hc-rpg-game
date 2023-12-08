package org.ht.rpg.game.utils;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.entities.*;
import org.springframework.cglib.transform.AbstractTransformTask;
import sun.java2d.pipe.AAShapePipe;

import java.util.*;
import java.util.stream.Collectors;

public class CombatUtils {
    public Map<Integer, Integer> calculateVelocity(Party parties, List<Choiche> fighterActions)
    {
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

        Map<Integer, Integer> orderedMap = calculatePriority(sortedEntries,fighterActions);

        return orderedMap;
    }

    private Map<Integer, Integer> calculatePriority(List<Map.Entry<Integer, Integer>> sortedEntries,List<Choiche> fighterActions) {
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
        Scanner tastiera = new Scanner(System.in);
        List<Choiche> scelte = null;
        for (Fighter member : parties.getAllyList()) {

            System.out.println("che cosa vuoi fare "+ member.getId() +" ?");
            System.out.println("1 attacck enemy ");
            System.out.println("2 use a magic ");
            System.out.println("3 use a item  ");
            System.out.println("4 run away");

            String scelta = tastiera.nextLine();
            switch (scelta) {
                case "1": {
                    for(Attack attacco : member.getAttacks()){
                        System.out.println(attacco.getName() + " " + attacco.getEffect());
                    }
                    //show Lista attacchi
                    //sottomenu Scelta attacco
                    // deve essere generato in modo che l'utente possa scegliere in base a qualsiasi attacco lui abbia
                    // problema tecnico
                    // scelta bersagio,
                }
                // idem per il resto

            }

        }
        return scelte;
    }

    public void makeActionsDO(Map<Integer, Integer> velocityOrder, List<Choiche> choichesOfAll) {
        System.out.println("porcodiooooo");
    }
}