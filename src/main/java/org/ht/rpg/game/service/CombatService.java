package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombatService {


    @Autowired
    PartyService partyService;

    @Autowired
    AllyService allyService;

    @Autowired
    EnemyService enemyService;

    @Autowired
    StoryService storyService;

    @Autowired
    MagicService magicService;

    @Autowired
    ConsumableService consumableService;



    public void fight(Party party){
        party.getAllyList();

    }
}
