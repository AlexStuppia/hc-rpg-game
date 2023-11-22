package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;

import java.util.ArrayList;
import java.util.List;

public class PartyService {
    public List<Ally> creaAlleati(){
        Ally alleato1 = new Ally();
        Ally alleato2 = new Ally();
        Ally alleato3 = new Ally();
        List<Ally> alleati = new ArrayList<Ally>();
        alleati.add(alleato1);
        alleati.add(alleato2);
        alleati.add(alleato3);
        return alleati;
    }

    public List<Enemy> creaNemici(){
        Enemy nemico1 = new Enemy();
        Enemy nemico2 = new Enemy();
        Enemy nemico3 = new Enemy();

        List<Enemy> nemici = new ArrayList<Enemy>();

        nemici.add(nemico1);
        nemici.add(nemico2);
        nemici.add(nemico3);
        return nemici;
    }

    public Party initParty(){
        List<Ally> alleati =  creaAlleati();
        List<Enemy> nemici = creaNemici();
        Party parties = new Party();
        parties.setAlleati(alleati);
        parties.setNemici(nemici);
        return parties;
    }

}
