package org.ht.rpg.game.main;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.entities.Story;
import org.ht.rpg.game.service.CombatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;

public class Play {
    @Autowired
    static CombatService combatService;

    public static void main(String[] args) throws FileNotFoundException {
        combatService.fight(new Party(), new Story());
    }
}
