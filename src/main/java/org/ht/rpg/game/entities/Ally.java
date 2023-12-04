package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;

public class Ally extends Fighter {


    public Ally() {
    }

    public Ally(int id, int velocita) {
        super(id, velocita);
    }

    public Ally(int id, boolean isTurnoOk, boolean isAlly, int exp, int level, int velocita, int lifePoints, int armorPoints, int manaPoints, Attack attack, Magic magic, Consumable consumable, boolean isDead, boolean isPoisoned, boolean isImmunePoisoned, boolean isLit, boolean isImmuneLitting, boolean isCursed, boolean isImmuneCursing, boolean isScared, boolean isImmuneToScare) {
        super(id, isTurnoOk, isAlly, exp, level, velocita, lifePoints, armorPoints, manaPoints, attack, magic, consumable, isDead, isPoisoned, isImmunePoisoned, isLit, isImmuneLitting, isCursed, isImmuneCursing, isScared, isImmuneToScare);
    }
}
