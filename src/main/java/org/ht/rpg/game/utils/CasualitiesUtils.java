package org.ht.rpg.game.utils;

import java.util.Random;

public class CasualitiesUtils {

    // metodo che crea un numero casuale in base ad un minimo ed un massimo che gli diamo
    public static int generaNumeroCasuale(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
