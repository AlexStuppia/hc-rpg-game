package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Party;
import org.springframework.beans.factory.annotation.Autowired;


public class Combat {
    //@Autowired
    public void prova(Party parties){
        for (int i = 0; i < parties.getNemici().size(); i++) {
            int element = parties.getNemici().get(i).getExp();
            System.out.println("IL NEMICO esperienza " + element);
        }

  //      for (int i = 0; i < parties.getAlleati().size(); i++) {
  //          int element = parties.getAlleati().get(i).getExp();
  //          System.out.println("IL alleartp  esperienza" + element);
  //     }
    }


}
