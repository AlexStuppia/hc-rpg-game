package org.ht.rpg.game.service;


import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Fighter;
import org.ht.rpg.game.utils.CasualitiesUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnemyService {

    public List<Enemy> createEnemy(String ambientazione){
        int provaid = 1;
        List<Enemy> nemici = new ArrayList<Enemy>();
        int numero = CasualitiesUtils.generaNumeroCasuale(1,6);
        for (int i = 0; i < numero; i++) {
            Enemy enemy = new Enemy();
            nemici.add(enemy);
        }
        switch (ambientazione)
        {
            case "cathedral":
            {
                System.out.println("sei in cattedrale");
                for (Fighter nemico : nemici) {
                    nemico.setId(provaid);
                    nemico.setExp(CasualitiesUtils.generaNumeroCasuale(10,40));
                    nemico.setVelocity(CasualitiesUtils.generaNumeroCasuale(100,400));
                    provaid++;
                }
            }
            break;
            case "inferno":
            {
                System.out.println("sei in inferno");
                for (Fighter nemico : nemici) {
                    nemico.setExp(CasualitiesUtils.generaNumeroCasuale(150,200));
                }
            }
            break;
            default:
            {
                System.out.println("erroraccio non deve finire qui denbrotp ");
                for (Fighter nemico : nemici) {
                    nemico.setExp(CasualitiesUtils.generaNumeroCasuale(1,10));
                }
            }
            break;
        }
        return nemici;
    }
}
