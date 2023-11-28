package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.springframework.beans.factory.annotation.Autowired;


public class Combat {
    //@Autowired
    public void prova(Party parties){
        System.out.println("la prova è" + parties.getAlleati() + "nemici sono" + parties.getNemici());
    }


}
