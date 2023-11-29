package org.ht.rpg.game.service;


import org.ht.rpg.game.entities.Story;
import org.ht.rpg.game.utils.StoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StoryService {

    @Autowired
    PartyService partyService;

    public Story getStoryText(String filePath) throws IOException {
        Story story = StoryUtils.readJson("src/main/resources/Json/" + filePath + ".json");
        return story;
    }

}
