package org.ht.rpg.game.service;


import org.ht.rpg.game.action.Attack;
import org.ht.rpg.game.action.Consumable;
import org.ht.rpg.game.action.Magic;
import org.ht.rpg.game.entities.Ally;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static sun.rmi.transport.TransportConstants.Magic;

@Service
public class AllyService {
    public List<Ally> createAllies(){
        List<Attack> attackList = new ArrayList<>();

        // qui cercherà i personaggi correlati del salvattagio,
        // di conseguenza passera questa lista a allyService gli passera una lista di id,
        //TODO
        //List<Ally> allylist = queryfromDb con tutti i dati del personaggio + i collegamti stesso al PG
        // for each per il quale ogni personaggio viene riempito dai dati di attacco e magie
        //List<Integer> idOfthe Attack = queryFromtheDB(IDPersonaggio);
        List<Integer> idOftheAttack = new ArrayList<>();
        idOftheAttack.add(100);
        idOftheAttack.add(42);
        idOftheAttack.add(23);
        idOftheAttack.add(24);
        attackList = AttackService.createAttaccks(idOftheAttack);
        List<Magic> prova = new ArrayList<>();
        Consumable cons = new Consumable();
        Ally ally1 = new Ally(1,true,true,20,1,
                20,10,50,54,attackList,prova,cons,"Abishek");
        Ally ally2 = new Ally(2,true,true,80,4,
                200,50,500,300,attackList,prova,cons,"Elyna");
        Ally ally3 = new Ally(3,true,true,40,2,
                88,30,40,90,attackList,prova,cons,"Davide");
        List<Ally> allies = new ArrayList<Ally>();
        allies.add(ally1);
        allies.add(ally2);
        allies.add(ally3);
        return allies;
    }
}
