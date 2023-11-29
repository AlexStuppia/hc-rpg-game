package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;

import java.util.Map;
public class Enemy extends Fighter {
    public Enemy() {

    }

    public Enemy(int id, boolean isTurnoOk, boolean isAlly, int exp, int level, int velocita, int lifePoints, int armorPoints, int manaPoints, Attack attack, Magic magic, Consumable consumable) {
        super(id, isTurnoOk, isAlly, exp, level, velocita, lifePoints, armorPoints, manaPoints, attack, magic, consumable);
    }


}
