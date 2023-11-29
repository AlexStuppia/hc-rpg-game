package org.ht.rpg.game.entities;

public class Story {

    String storyTitle;
    String storyText;
    String environment;
    String encounterType;

    public Story() {
    }


    public Story(String storyTitle, String storyText, String environment, String encounterType) {
        this.storyTitle = storyTitle;
        this.storyText = storyText;
        this.environment = environment;
        this.encounterType = encounterType;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEncounterType() {
        return encounterType;
    }

    public void setEncounterType(String encounterType) {
        this.encounterType = encounterType;
    }
}
