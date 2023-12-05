package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartyService {


    // TODO move createAlly and createEnemy in allyservice e enemyService
    public List<Ally> creaAlleati(){
        Ally alleato1 = new Ally(120,1);
        Ally alleato2 = new Ally(102,2);
        Ally alleato3 = new Ally(103,3);
        List<Ally> alleati = new ArrayList<Ally>();
        alleati.add(alleato1);
        alleati.add(alleato2);
        alleati.add(alleato3);
        return alleati;
    }

    public List<Enemy> creaNemici(String ambientazione){
        int provaid = 1;
        List<Enemy> nemici = new ArrayList<Enemy>();
        int numero = generaNumeroCasuale(1,6);
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
                    nemico.setExp(generaNumeroCasuale(10,40));
                    nemico.setVelocita(generaNumeroCasuale(100,400));
                    provaid++;
                }
            }
            break;
            case "inferno":
            {
                System.out.println("sei in inferno");
                for (Fighter nemico : nemici) {
                    nemico.setExp(generaNumeroCasuale(150,200));
                }
            }
            break;
            default:
            {
                System.out.println("erroraccio non deve finire qui denbrotp ");
                for (Fighter nemico : nemici) {
                    nemico.setExp(generaNumeroCasuale(1,10));
                }
            }
            break;
        }
        return nemici;
    }

    public Party initParty(Story storia){
        List<Ally> alleati =  creaAlleati();
        List<Enemy> nemici = creaNemici(storia.getEnvironment());
        Party parties = new Party();
        parties.setAllyList(alleati);
        parties.setEnemyList(nemici);
        return parties;
    }


    // metodo che crea un numero casuale in base ad un minimo ed un massimo che gli diamo
    private static int generaNumeroCasuale(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
