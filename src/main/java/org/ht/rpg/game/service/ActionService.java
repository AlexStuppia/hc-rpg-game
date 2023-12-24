package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Choiche;
import org.ht.rpg.game.entities.Party;

public class ActionService {
    public Party useAction(Party party, Choiche singleChoiche) {
        System.out.println(singleChoiche.getAction().getName() +" used by " + singleChoiche.getSender().getName() + " to " +  singleChoiche.getListOfTargets());
        return party;
    }
}
