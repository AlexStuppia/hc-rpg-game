package org.ht.rpg.game.service;


import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyService {
    public Party initEntities() {
        List<Ally> allyList = new ArrayList<>();
        List<Enemy> enemyList = new ArrayList<>();
        Party party = new Party();
        Enemy enemy = new Enemy();
        Ally ally = new Ally();

        allyList.add(ally);
        enemyList.add(enemy);

        party.setAllyList(allyList);
        party.setEnemyList(enemyList);


        return party;
    }

    public List<Ally> createAllies(){
        Ally alleato1 = new Ally();
        Ally alleato2 = new Ally();
        Ally alleato3 = new Ally();
        List<Ally> alleati = new ArrayList<Ally>();
        alleati.add(alleato1);
        alleati.add(alleato2);
        alleati.add(alleato3);
        return alleati;
    }

    public List<Enemy> createEnemies(){
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
        List<Ally> alleati =  createAllies();
        List<Enemy> nemici = createEnemies();
        Party parties = new Party();
        parties.setAllyList(alleati);
        parties.setEnemyList(nemici);
        return parties;
    }


}
