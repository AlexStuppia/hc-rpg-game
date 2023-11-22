package org.ht.rpg.game.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class StoryUtils {


    public static String readJson(String jsonStoryFilePath, String storyKey) throws FileNotFoundException {
        JSONParser parser = new JSONParser(new FileReader(jsonStoryFilePath));
        String value = "";

        try {
            Object obj = parser.parse();

            JSONObject jsonObject = (JSONObject) obj;
            // Now you can access values by their key
             value = (String) jsonObject.get(storyKey);

            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}

