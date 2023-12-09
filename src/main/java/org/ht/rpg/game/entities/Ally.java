package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;

import java.util.List;


public class Ally extends Fighter {
    private String name;


    public Ally(int id, boolean isTurnoOk, boolean isAlly, int exp, int level, int velocity, int lifePoints, int armorPoints, int manaPoints, List<Attack> attacks, List<Magic> magics, Consumable consumable, String name) {
        super(id, isTurnoOk, isAlly, exp, level, velocity, lifePoints, armorPoints, manaPoints, attacks, magics, consumable);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
