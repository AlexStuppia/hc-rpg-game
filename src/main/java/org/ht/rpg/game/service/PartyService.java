package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Ally;
import org.ht.rpg.game.entities.Enemy;
import org.ht.rpg.game.entities.Party;
import org.ht.rpg.game.entities.Story;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartyService {
    public List<Ally> creaAlleati(){
        Ally alleato1 = new Ally(120);
        Ally alleato2 = new Ally(102);
        Ally alleato3 = new Ally(103);
        List<Ally> alleati = new ArrayList<Ally>();
        alleati.add(alleato1);
        alleati.add(alleato2);
        alleati.add(alleato3);
        return alleati;
    }

    public List<Enemy> creaNemici(String ambientazione){

        List<Enemy> nemici = new ArrayList<Enemy>();
        int numero = generaNumeroCasuale(1,6);
        for (int i = 0; i < numero; i++) {
            nemici.add(new Enemy());
        }
        switch (ambientazione)
        {
            case "cattedrale":
            {
                System.out.println("sei in cattedrale");
                for (Enemy nemico : nemici) {
                    nemico.setExp(generaNumeroCasuale(10,40));
                }
            }
            break;
            case "inferno":
            {
                System.out.println("sei in inferno");
                for (Enemy nemico : nemici) {
                    nemico.setExp(generaNumeroCasuale(150,200));
                }
            }
            break;
            default:
            {
                System.out.println("erroraccio non deve finire qui denbrotp ");
                for (Enemy nemico : nemici) {
                    nemico.setExp(generaNumeroCasuale(1,10));
                }
            }
            break;
        }
        return nemici;
    }

    public Party initParty(Story storia){
        List<Ally> alleati =  creaAlleati();
        List<Enemy> nemici = creaNemici(storia.getAmbientazione());
        Party parties = new Party();
        parties.setAlleati(alleati);
        parties.setNemici(nemici);
        return parties;
    }


    // metodo che crea un numero casuale in base ad un minimo ed un massimo che gli diamo
    private static int generaNumeroCasuale(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
