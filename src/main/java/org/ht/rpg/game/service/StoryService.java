package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.entities.Story;

public class StoryService {
    public static void main(String[] args) {
        String ambientazione = "cattedrale";
        String tipoDiIncontro ="casuale";
        Story storia = new Story(ambientazione,tipoDiIncontro);
        PartyService partyService = new PartyService();
        Party party = partyService.initParty(storia);
        Combat combat = new Combat();
        combat.prova(party);
    }
}
