package org.ht.rpg.game.service;


import org.ht.rpg.game.entities.Ally;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllyService {
    public List<Ally> createAllies(){
        Ally ally1 = new Ally(120,1);
        Ally ally2 = new Ally(102,2);
        Ally ally3 = new Ally(103,3);
        List<Ally> allies = new ArrayList<Ally>();
        allies.add(ally1);
        allies.add(ally2);
        allies.add(ally3);
        return allies;
    }
}
