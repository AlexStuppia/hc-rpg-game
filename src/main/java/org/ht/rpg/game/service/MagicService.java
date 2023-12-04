package org.ht.rpg.game.service;


import org.ht.rpg.game.action.Magic;
import org.ht.rpg.game.entities.Party;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicService {


    public void poisonSperm(Party party, int idCaster, List<Integer> idBersagli){
        Magic magic = new Magic();
        magic.setId(0);
        magic.setName("poisonSperm");
        magic.setQuantity(1);
        magic.setEffect("potenzia attacco fisico di 30," +
                "/n Ogni colpo a una chance del 10% di avvelenare per quel turno soltanto");




    }



}
