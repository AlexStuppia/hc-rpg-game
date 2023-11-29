package org.ht.rpg.game.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ht.rpg.game.action.Attack;

import java.util.Map;


@NoArgsConstructor()
@AllArgsConstructor()
@Getter
@Setter
public abstract class Fighter {

    public int velocita;
    //definisce se il personaggio puo conseguire il turno o meno
    private int id;
    private boolean isTurnoOk;
    private int exp;
    private int level;
    private int lifePoints;
    private int armorPoints;
    private int manaPoints;
    private Attack attack;
    private Map<String,Boolean> magies;
    private Map<String,Boolean> consumables;


}
