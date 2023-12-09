package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;

import java.util.List;
import java.util.Map;
public class Enemy extends Fighter {

    private String type;

    public Enemy() {
    }

    public Enemy(int id, boolean isTurnOk, boolean isAlly, int exp, int level, int velocity, int lifePoints, int armorPoints, int manaPoints, List<Attack> attacks, List<Magic> magics, Consumable consumable, String type) {
        super(id, isTurnOk, isAlly, exp, level, velocity, lifePoints, armorPoints, manaPoints, attacks, magics, consumable);
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
