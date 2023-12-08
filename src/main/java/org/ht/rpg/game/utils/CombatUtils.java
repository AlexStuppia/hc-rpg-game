package org.ht.rpg.game.utils;

import org.ht.rpg.game.entities.*;

import java.util.*;

public class CombatUtils {
    public Map<Integer, Integer> calculateVelocity(Party parties, List<Choiche> fighterActions) {
        Map<Integer, Integer> mappaVelocita = new HashMap<>();
        for (Enemy nemico : parties.getEnemyList()) {
            mappaVelocita.put(nemico.getId(), nemico.getVelocity());
        }
        for (Ally alleato : parties.getAllyList()) {
            mappaVelocita.put(alleato.getId(), alleato.getVelocity());
        }

        // Ordinare la mappa in base alla velocità in ordine decrescente
        Map<Integer, Integer> mappaOrdinata = new LinkedHashMap<>();
        mappaVelocita.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> mappaOrdinata.put(entry.getKey(), entry.getValue()));

        for (Choiche choice: fighterActions) {
            if (choice.isActionPriority()){

            }
            else if (choice.isActionInversePriority())
            {

            }
        }

        return mappaOrdinata;
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

            System.out.println("che cosa vuoi fare ?");
            System.out.println("1 attacchi : " + member.getAttacks());
            System.out.println("2 magie : " + member.getMagics());
            System.out.println("3 consumabili : " + member.getConsumable());
            System.out.println("4 fuga");

            String scelta = tastiera.nextLine();
            switch (scelta) {
                case "1": {
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
}