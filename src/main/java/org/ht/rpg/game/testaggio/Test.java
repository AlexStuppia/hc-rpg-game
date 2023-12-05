package org.ht.rpg.game.testaggio;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.entities.Story;
import org.ht.rpg.game.service.CombatService;
import org.ht.rpg.game.service.PartyService;

public class Test {
    public static void main(String[] args) {
        Story storia = new Story("cap1","boh","cathedral","random");
        PartyService partyService = new PartyService();
        CombatService combatService = new CombatService();
        Party party = new Party();
        party = partyService.initParty(storia);
        combatService.startCombat(party);

    }
}
