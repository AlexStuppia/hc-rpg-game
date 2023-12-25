package org.ht.rpg.game.service;


import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Magic;
import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Choiche;
import org.ht.rpg.game.entities.Fighter;
import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.utils.CombatUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagicService {

    public static List<Magic> createMagics(List<Integer> idOfthemagic) {
        List<Magic> MagicList = new ArrayList<>();
        for (Integer id : idOfthemagic) {
            Magic magic = new Magic();
            switch (id) {
                case (10): {
                    magic.setId(10);
                    magic.setName("FlameTrower");
                    magic.setQuantity(20);
                    magic.setDamage(40);
                    magic.setPriority(false);
                    magic.setPriorityLast(false);
                    magic.setEffect("hit all enemy with a big flame");
                    magic.setCanTargetAlly(false);
                    magic.setCanTargetDeadAlly(false);
                    magic.setCanTargetDeadEnemy(false);
                    magic.setCanAttackMultiTarget(false);
                    magic.setNumberOfTarget(1);
                    magic.setHittingAllEnemy(true);
                    magic.setHittingAllAlly(false);
                    magic.setHittingAllPlayer(false);
                    MagicList.add(magic);
                    break;
                }
                case (11): {
                    magic.setId(11);
                    magic.setName("Allahu akbar");
                    magic.setQuantity(20);
                    magic.setDamage(400);
                    magic.setPriority(false);
                    magic.setPriorityLast(true);
                    magic.setEffect(" ti fai saltare in aria,muori ma fai un botto di danno ad un nemico");
                    magic.setCanTargetAlly(false);
                    magic.setCanTargetDeadAlly(false);
                    magic.setCanTargetDeadEnemy(false);
                    magic.setCanAttackMultiTarget(false);
                    magic.setNumberOfTarget(1);
                    magic.setHittingAllEnemy(false);
                    magic.setHittingAllAlly(false);
                    magic.setHittingAllPlayer(false);
                    MagicList.add(magic);
                    break;
                }
                case (12): {
                    magic.setId(12);
                    magic.setName("Chiamata agli Angeli");
                    magic.setQuantity(20);
                    magic.setDamage(10);
                    magic.setPriority(true);
                    magic.setPriorityLast(false);
                    magic.setEffect(" rianima un compare morto");
                    magic.setCanTargetAlly(true);
                    magic.setCanTargetDeadAlly(true);
                    magic.setCanTargetDeadEnemy(false);
                    magic.setCanAttackMultiTarget(false);
                    magic.setNumberOfTarget(1);
                    magic.setHittingAllEnemy(false);
                    magic.setHittingAllAlly(false);
                    magic.setHittingAllPlayer(false);
                    MagicList.add(magic);
                    break;
                }
                case 13 :
                {
                    magic.setId(13);
                    magic.setName("Ditone nel Culo");
                    magic.setQuantity(8);
                    magic.setDamage(100000000);
                    magic.setPriority(true);
                    magic.setPriorityLast(false);
                    magic.setEffect("insert a big finger in the ass of the enemy, instaKill");
                    magic.setCanTargetAlly(false);
                    magic.setCanTargetDeadAlly(false);
                    magic.setCanTargetDeadEnemy(false);
                    magic.setCanAttackMultiTarget(true);
                    magic.setNumberOfTarget(1);
                    magic.setHittingAllEnemy(false);
                    magic.setHittingAllAlly(false);
                    magic.setHittingAllPlayer(false);
                    MagicList.add(magic);
                    break;
                }
            }
        }
        return MagicList;
    }
    public static Party useMagic(Party party, Choiche singleChoiche) {
            switch (singleChoiche.getAction().getId()){
                case 10 : {
                    //flamethrower
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
                case 11 :
                {
                    //allahu akbar
                    for (Fighter target : singleChoiche.getListOfTargets())
                    {
                        for (Fighter oldTarget : party.getEnemyList()) {
                            if (target.getId() == oldTarget.getId()) {
                                System.out.println("vita prima attacco " + singleChoiche.getAction().getName() + " " + target.getLifePoints());
                                target.setLifePoints(target.getLifePoints() - (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                                System.out.println("danno fatto = " + (singleChoiche.getAction().getDamage() * singleChoiche.getSender().getLevel()));
                                party = CombatUtils.checkPGdead(party, target);
                            }
                        }
                    }
                    for (Fighter ally : party.getAllyList())
                    {
                     if (ally.getId() == singleChoiche.getSender().getId()) {
                         ally.setDead(true);
                         ally.setLifePoints(0);
                        party.getDeadAllyList().add((Ally) ally);
                    }
                    }
                    break;
                }
                case 12 :
                {
                    //chiamata dell'angelo
                    for (Fighter target : singleChoiche.getListOfTargets())
                    {
                        for (Fighter oldTarget : party.getEnemyList())
                        {
                            if (target.getId() == oldTarget.getId())
                            {
                                target.setLifePoints(100);
                                target.setDead(false);
                                System.out.println("il personaggio " + target.getName() + " è tornato in vita");
                                party.getDeadAllyList().remove(target);
                                party = CombatUtils.checkPGdead(party,target);
                                break;
                            }
                        }
                    }
                    break;
                }
                case 13 :
                {
                    //dito in culo
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
            }
            return party;
    }
}
