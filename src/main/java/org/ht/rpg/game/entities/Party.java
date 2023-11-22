package org.ht.rpg.game.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Party {

    List<Ally> alleati;
    List<Enemy> nemici;





    public List<Enemy> getNemici() {
        return nemici;
    }

    public void setNemici(List<Enemy> nemici) {
        this.nemici = nemici;
    }

    public List<Ally> getAlleati() {
        return alleati;
    }

    public void setAlleati(List<Ally> alleati) {
        this.alleati = alleati;
    }



}
