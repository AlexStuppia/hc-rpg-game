package org.ht.rpg.game.controller;


import org.ht.rpg.game.dto.CustomResponse;
import org.ht.rpg.game.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("story")
public class StoriaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoriaController.class);
    private static final String OK = "ok!";
    Instant start;
    Instant finish;

    //dependencies
    @Autowired
    StoryService storyService;


    @PostMapping(value = "getDialogue")
    public ResponseEntity<CustomResponse> storiaTest(
           /*@RequestHeader("Authorization") String bearerToken,*/
            @RequestBody Map<String, Object> request) throws IOException {

       /* if (!Objects.equals(bearerToken, "123")) {
            return new ResponseEntity<>(new CustomResponse(null, "invalid token", "insert a valid header token"), HttpStatus.FORBIDDEN);
        }*/

        CustomResponse response = new CustomResponse();
        ResponseEntity responseEntity = null;

        try {
            start = Instant.now();
            response.setResponse(storyService.getStoryText(request.get("jsonName").toString()));
            response.setMsg(OK);
            if (response.getResponse() != null) {
                responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (NullPointerException n) {
            response.setResponse(false);
            response.setMsg("No element found");
            response.setDetail(n.getMessage());
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            return responseEntity;

        } catch (Exception ex) {
            response.setResponse(false);
            response.setMsg("Server Error");
            response.setDetail(ex.getMessage());
            throw ex;
        } finally {
            finish = Instant.now();
            long time = Duration.between(start, finish).toMillis();
            LOGGER.trace("getDialogue: {} ms ", time);
            LOGGER.info("getDialogue: {} ms ", time);
        }
        return responseEntity;

    }

}
