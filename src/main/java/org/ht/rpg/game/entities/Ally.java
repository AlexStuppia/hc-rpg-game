package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;

import java.util.Map;

public class Ally extends Fighter {
    public Ally(int velocita,int id, boolean isTurnoOk, int exp, int level, int lifePoints, int armorPoints, int manaPoints, Attack attack, Map<String, Boolean> magies, Map<String, Boolean> consumables) {
        super(velocita,id,isTurnoOk, exp, level, lifePoints, armorPoints, manaPoints, attack, magies, consumables);
    }

    public Ally(int velocita,int id) {
    }
}
