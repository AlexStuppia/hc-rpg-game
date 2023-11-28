package org.ht.rpg.game.controller;


import org.ht.rpg.game.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class ProvaController {
    @Autowired
    StoryService storyService;


    @PostMapping
    public String storiaTest() throws FileNotFoundException {
        String s = storyService.getStoryText("src/main/resources/Json/JsonStory.json", "storia1");
        return s;
    }

}
