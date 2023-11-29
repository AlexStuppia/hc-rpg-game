package org.ht.rpg.game.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ht.rpg.game.entities.Story;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


@Component
public class StoryUtils {


    public static Story readJson(String filePath) throws IOException {
        Story ret = new Story();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ret = objectMapper.readValue(new File(filePath), Story.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}

