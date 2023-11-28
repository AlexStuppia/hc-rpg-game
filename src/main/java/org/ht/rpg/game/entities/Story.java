package org.ht.rpg.game.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Story {

    private String ambientazione;
    private String tipoDiIncontro;
    public Story(String ambientazione,String tipoDiIncontro){
        this.ambientazione = ambientazione;
        this.tipoDiIncontro = tipoDiIncontro;
    }

}
