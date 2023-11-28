package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;

import java.util.ArrayList;
import java.util.List;

public class Story {
    public static void main(String[] args) {
        PartyService partyService = new PartyService();
        Party party = partyService.initParty();
        Combat combat = new Combat();
        combat.prova(party);
    }
}
