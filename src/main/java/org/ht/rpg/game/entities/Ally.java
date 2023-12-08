package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;

import java.util.List;

public class Ally extends Fighter {
    public Ally(int id, boolean isTurnoOk, boolean isAlly, int exp, int level, int velocity, int lifePoints, int armorPoints, int manaPoints, List<Attack> attacks, List<Magic> magics, Consumable consumable) {
        super(id, isTurnoOk, isAlly, exp, level, velocity, lifePoints, armorPoints, manaPoints, attacks, magics, consumable);
    }
}
