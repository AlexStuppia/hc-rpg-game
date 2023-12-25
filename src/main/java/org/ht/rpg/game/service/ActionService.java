package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Choiche;
import org.ht.rpg.game.entities.Party;

public class ActionService {
    public Party useAction(Party party, Choiche singleChoiche) {
        System.out.println(singleChoiche.getAction().getName() +" used by " + singleChoiche.getSender().getName() + " to " +  singleChoiche.getListOfTargets());
        if(singleChoiche.getAction().getClass().getName().contains("Attack")){
            System.out.println("attacco");
            party = AttackService.useAttack(party, singleChoiche);
            // metodo controllo se pg è morto o meno dopo calcolo danni
        }
        else if(singleChoiche.getAction().getClass().getName().contains("Magic")) {
            party = MagicService.useMagic(party, singleChoiche);
            System.out.println("magia");
            // metodo controllo se pg è morto o meno dopo calcolo danni
        }
        return party;
    }
}
