package org.ht.rpg.game.service;

import org.ht.rpg.game.action.Attack;

import java.util.ArrayList;
import java.util.List;

public class AttackService {


    // momentaneamente crea gli attacchi con uno switch, in futuro
    // fara la query sul Db per ottenere i vari dati
    public static List<Attack> createAttaccks(List<Integer> idsOfTheAttack) {
        List<Attack> attackList = new ArrayList<>();
        for (Integer id : idsOfTheAttack) {
            Attack attack = new Attack();
            switch (id) {
                case (100): {
                    attack.setId(100);
                    attack.setName("NormalAttack");
                    attack.setQuantity(20);
                    attack.setDamage(20);
                    attack.setPriority(false);
                    attack.setPriorityLast(false);
                    attack.setEffect("a normal attack");
                    attack.setCanTargetAlly(false);
                    attack.setCanAttackMultiTarget(false);
                    attack.setNumberOfTarget(1);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
                case (42): {
                    attack.setId(42);
                    attack.setName("SlowAttack");
                    attack.setQuantity(20);
                    attack.setDamage(40);
                    attack.setPriority(false);
                    attack.setPriorityLast(true);
                    attack.setEffect("you attack for the last, but you do a lot of damage");
                    attack.setCanTargetAlly(false);
                    attack.setCanAttackMultiTarget(false);
                    attack.setNumberOfTarget(1);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
                case (23): {
                    attack.setId(23);
                    attack.setName("FastAttack");
                    attack.setQuantity(20);
                    attack.setDamage(10);
                    attack.setPriority(true);
                    attack.setPriorityLast(false);
                    attack.setEffect("you attack for the first, but do a small amount of damage");
                    attack.setCanTargetAlly(false);
                    attack.setCanAttackMultiTarget(false);
                    attack.setNumberOfTarget(1);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
                case 24 :
                {
                    attack.setId(24);
                    attack.setName("shadowFinger");
                    attack.setQuantity(8);
                    attack.setDamage(10);
                    attack.setPriority(true);
                    attack.setPriorityLast(false);
                    attack.setEffect("you attack for the first, two target but do a small amount of damage");
                    attack.setCanTargetAlly(false);
                    attack.setCanAttackMultiTarget(true);
                    attack.setNumberOfTarget(3);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
            }
        }
        return attackList;
    }
}