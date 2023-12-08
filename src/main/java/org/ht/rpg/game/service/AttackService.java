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
                case (1): {
                    attack.setId(1);
                    attack.setName("NormalAttack");
                    attack.setQuantity(20);
                    attack.setPriority(false);
                    attack.setPriorityLast(false);
                    attack.setEffect("a normal attack");
                    attackList.add(attack);
                    break;
                }
                case (2): {
                    attack.setId(2);
                    attack.setName("SlowAttack");
                    attack.setQuantity(20);
                    attack.setPriority(false);
                    attack.setPriorityLast(true);
                    attack.setEffect("you attack for the last, but you do a lot of damage");
                    attackList.add(attack);
                    break;
                }
                case (3): {
                    attack.setId(3);
                    attack.setName("FastAttack");
                    attack.setQuantity(20);
                    attack.setPriority(true);
                    attack.setPriorityLast(false);
                    attack.setEffect("you attack for the first, but do a small amount of damage");
                    attackList.add(attack);
                    break;
                }
            }
        }
        return attackList;
    }
}
