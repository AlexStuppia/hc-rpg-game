package org.ht.rpg.game.service;


import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Magic;
import org.ht.rpg.game.entities.Choiche;
import org.ht.rpg.game.entities.Party;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagicService {


    public static Party useMagic(Party party, Choiche singleChoiche) {
        System.out.println("METODO USE MAGIC ATTIVAGTO ");
        return  party;
    }

    public static List<Magic> createMagics(List<Integer> idOfthemagic) {
        List<Magic> MagicList = new ArrayList<>();
        for (Integer id : idOfthemagic) {
            Magic magic = new Magic();
            switch (id) {
                case (10): {
                    magic.setId(10);
                    magic.setName("FlameTrower");
                    magic.setQuantity(20);
                    magic.setDamage(20);
                    magic.setPriority(false);
                    magic.setPriorityLast(false);
                    magic.setEffect("a normal attack");
                    magic.setCanTargetAlly(false);
                    magic.setCanAttackMultiTarget(false);
                    magic.setNumberOfTarget(1);
                    magic.setHittingAllEnemy(false);
                    magic.setHittingAllAlly(false);
                    magic.setHittingAllPlayer(false);
                    MagicList.add(magic);
                    break;
                }
                case (11): {
                    magic.setId(11);
                    magic.setName("IceBeam");
                    magic.setQuantity(20);
                    magic.setDamage(40);
                    magic.setPriority(false);
                    magic.setPriorityLast(true);
                    magic.setEffect("you attack for the last, but you do a lot of damage");
                    magic.setCanTargetAlly(false);
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
                    magic.setName("Bestemmione");
                    magic.setQuantity(20);
                    magic.setDamage(10);
                    magic.setPriority(true);
                    magic.setPriorityLast(false);
                    magic.setEffect("you attack for the first, but do a small amount of damage");
                    magic.setCanTargetAlly(false);
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
                    magic.setDamage(10);
                    magic.setPriority(true);
                    magic.setPriorityLast(false);
                    magic.setEffect("insert a big finger in the ass of the enemy");
                    magic.setCanTargetAlly(false);
                    magic.setCanAttackMultiTarget(true);
                    magic.setNumberOfTarget(3);
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

    public void flamethrower(Party party, int id){
        Magic magic = new Magic();
        magic.setEffect("");
    }



}
