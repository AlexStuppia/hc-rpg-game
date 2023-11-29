package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;

import java.util.Map;

public class Ally extends Character{
    public Ally(boolean isTurnoOk, int exp, int level, int lifePoints, int armorPoints, int manaPoints, Attack attack, Map<String, Boolean> magies, Map<String, Boolean> consumables) {
        super(isTurnoOk, exp, level, lifePoints, armorPoints, manaPoints, attack, magies, consumables);
    }

}
