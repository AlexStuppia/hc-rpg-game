package org.ht.rpg.game.service;


import org.ht.rpg.game.utils.StoryUtils;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class StoryService {


    public String getStoryText(String filePath, String storyKey) throws FileNotFoundException {
        return StoryUtils.readJson("src/main/resources/Json/JsonStory.json", "storia1");
    }
}
