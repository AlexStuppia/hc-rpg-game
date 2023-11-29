package org.ht.rpg.game.service;


import org.ht.rpg.game.action.Magic;
import org.ht.rpg.game.entities.Party;
import org.springframework.stereotype.Service;

@Service
public class MagicService {


    public void flamethrower(Party party, int id){
        Magic magic = new Magic();
        magic.setEffect("");
    }



}