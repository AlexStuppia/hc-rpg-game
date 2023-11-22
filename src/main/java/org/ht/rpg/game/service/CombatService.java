package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.entities.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

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




    public void fight(Party party, Story story) throws FileNotFoundException {
           String text = storyService.getStoryText("src/main/resources/Json/JsonStory.json", "storia1");

        System.out.println(text);

    }


}
