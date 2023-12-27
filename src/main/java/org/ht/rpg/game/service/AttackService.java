package org.ht.rpg.game.service;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.entities.*;
import org.ht.rpg.game.utils.CombatUtils;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AttackService {


    // momentaneamente crea gli attacchi con uno switch, in futuro
    // fara la query sul Db per ottenere i vari dati
    public static List<Attack> createAttaccks(List<Integer> idsOfTheAttack) {
        List<Attack> attackList = new ArrayList<>();
        for (Integer id : idsOfTheAttack) {
            Attack attack = new Attack();
            switch (id) {
                case (10): {
                    attack.setId(10);
                    attack.setName("NormalAttack");
                    attack.setQuantity(20);
                    attack.setDamage(20);
                    attack.setPriority(false);
                    attack.setPriorityLast(false);
                    attack.setEffect("a normal attack");
                    attack.setCanTargetAlly(false);
                    attack.setCanTargetDeadAlly(false);
                    attack.setCanTargetDeadEnemy(false);
                    attack.setCanAttackMultiTarget(false);
                    attack.setNumberOfTarget(1);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
                case (11): {
                    attack.setId(11);
                    attack.setName("SlowAttack");
                    attack.setQuantity(20);
                    attack.setDamage(30);
                    attack.setPriority(false);
                    attack.setPriorityLast(true);
                    attack.setEffect("you attack for the last, but you do a lot of damage");
                    attack.setCanTargetAlly(false);
                    attack.setCanTargetDeadAlly(false);
                    attack.setCanTargetDeadEnemy(false);
                    attack.setCanAttackMultiTarget(false);
                    attack.setNumberOfTarget(1);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
                case (12): {
                    attack.setId(12);
                    attack.setName("FastAttack");
                    attack.setQuantity(20);
                    attack.setDamage(5);
                    attack.setPriority(true);
                    attack.setPriorityLast(false);
                    attack.setEffect("you attack for the first, but do a small amount of damage");
                    attack.setCanTargetAlly(false);
                    attack.setCanTargetDeadAlly(false);
                    attack.setCanTargetDeadEnemy(false);
                    attack.setCanAttackMultiTarget(false);
                    attack.setNumberOfTarget(1);
                    attack.setHittingAllEnemy(false);
                    attack.setHittingAllAlly(false);
                    attack.setHittingAllPlayer(false);
                    attackList.add(attack);
                    break;
                }
                case 13 :
                {
                    attack.setId(13);
                    attack.setName("shadowFinger");
                    attack.setQuantity(8);
                    attack.setDamage(3);
                    attack.setPriority(true);
                    attack.setPriorityLast(false);
                    attack.setEffect("you attack for the first, two target but do a small amount of damage");
                    attack.setCanTargetAlly(false);
                    attack.setCanTargetDeadAlly(false);
                    attack.setCanTargetDeadEnemy(false);
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

    public static Party useAttack(Party party, Choiche singleChoiche) {
        switch (singleChoiche.getAction().getId()){
            case 10 : {
                //normal attack
                for (Fighter target : singleChoiche.getListOfTargets())
                {
                    for (Fighter oldTarget : party.getEnemyList())
                    {
                        if (target.getId() == oldTarget.getId())
                        {
                            System.out.println("vita prima attacco " + singleChoiche.getAction().getName() + " " + target.getLifePoints());
                            target.setLifePoints(target.getLifePoints() - (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            System.out.println("danno fatto = " + (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            party = CombatUtils.checkPGdead(party,target);
                            break;
                        }
                    }
                }
                break;
            }
            case 11 :
            {
                //slow attack
                for (Fighter target : singleChoiche.getListOfTargets())
                {
                    for (Fighter oldTarget : party.getEnemyList())
                    {
                        if (target.getId() == oldTarget.getId())
                        {
                            System.out.println("vita prima attacco " + singleChoiche.getAction().getName() + " " + target.getLifePoints());
                            target.setLifePoints(target.getLifePoints() - (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            System.out.println("danno fatto = " + (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            party = CombatUtils.checkPGdead(party,target);
                            break;
                        }
                    }
                }
                break;
            }
            case 12 :
            {
                //fast attack
                for (Fighter target : singleChoiche.getListOfTargets())
                {
                    for (Fighter oldTarget : party.getEnemyList())
                    {
                        if (target.getId() == oldTarget.getId())
                        {
                            System.out.println("vita prima attacco " + singleChoiche.getAction().getName() + " " + target.getLifePoints());
                            target.setLifePoints(target.getLifePoints() - (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            System.out.println("danno fatto = " + (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            party = CombatUtils.checkPGdead(party,target);
                            break;
                        }
                    }
                }
                break;
            }
            case 13 :
            {
                //colpo multiplo
                for (Fighter target : singleChoiche.getListOfTargets())
                {
                    for (Fighter oldTarget : party.getEnemyList())
                    {
                        if (target.getId() == oldTarget.getId())
                        {
                            System.out.println("vita prima attacco " + singleChoiche.getAction().getName() + " " + target.getLifePoints());
                            target.setLifePoints(target.getLifePoints() - (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            System.out.println("danno fatto = " + (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                            party = CombatUtils.checkPGdead(party,target);
                        }
                    }
                }
                break;
            }
        }
        return party;
    }
}
