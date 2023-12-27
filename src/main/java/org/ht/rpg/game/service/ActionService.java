package org.ht.rpg.game.service;

import org.ht.rpg.game.entities.Choiche;
import org.ht.rpg.game.entities.Fighter;
import org.ht.rpg.game.entities.Party;

import java.util.ArrayList;
import java.util.List;

public class ActionService {
    public Party useAction(Party party, Choiche singleChoiche) {
        // if più esterno aggiunto per fare in modo che se il sender muore nei turni precedenti, non gli fa eseguire
        // erroneamente l'azione ma skippa l'azione
        if (singleChoiche.getSender().isDead() == false) {
            // per evitare che si possa colpire più volte un nemico morto,si controlla se l'azione può attacare un nemico morto
            // se non può farlo e nessuno dei target è morto va tutto normale e si esegue l'attaco, altrimenti rimuove i target
            // morti dalla lista dei target
            if (singleChoiche.getAction().getCanTargetDeadAlly() == false &&
                    singleChoiche.getAction().getCanTargetDeadEnemy() == false &&
                    singleChoiche.getListOfTargets().stream().anyMatch(fighter -> fighter.isDead() == false) == true )
            {
                System.out.println(singleChoiche.getAction().getName() + " used by " + singleChoiche.getSender().getName() + " to " + singleChoiche.getListOfTargets());
                if (singleChoiche.getAction().getClass().getName().contains("Attack")) {
                    System.out.println("attacco");
                    party = AttackService.useAttack(party, singleChoiche);
                    // metodo controllo se pg è morto o meno dopo calcolo danni
                } else if (singleChoiche.getAction().getClass().getName().contains("Magic")) {
                    System.out.println("magia");
                    party = MagicService.useMagic(party, singleChoiche);
                    // metodo controllo se pg è morto o meno dopo calcolo danni
                }
            }
            // controllo se l'azione non può attacare morti, tuttavia se ci sono nemici morti nei target
            // li rimuove dalla lista dei target e fa in modo di evitare ripetuti attacchi su nemici morti
            else if(singleChoiche.getAction().getCanTargetDeadAlly() == false &&
                    singleChoiche.getAction().getCanTargetDeadEnemy() == false &&
                    singleChoiche.getListOfTargets().stream().anyMatch(fighter -> fighter.isDead() == false) == false)
            {
                List<Fighter> targetDeadToRemove = new ArrayList<>(); // creata lista di appoggio, poiche la rimozione diretta dava problemi
                for (Fighter target : singleChoiche.getListOfTargets()){
                    if (target.isDead() == true)
                    {
                        System.out.println(target.getName() + " è a terra è non verra colpito");
                        targetDeadToRemove.add(target);
                    }
                }
                for (Fighter targetToRemove : targetDeadToRemove) {
                        singleChoiche.getListOfTargets().remove(targetToRemove);
                }
                if (singleChoiche.getListOfTargets().size() == 0){
                    System.out.println(singleChoiche.getSender().getName() + " prova a usare "
                            + singleChoiche.getAction().getName()
                            + " ma tutti i nemici che voleva colpire sono a terra e non si muovono :( ");
                }
                else {
                    System.out.println(singleChoiche.getAction().getName() + " used by " + singleChoiche.getSender().getName() + " to " + singleChoiche.getListOfTargets());
                    if (singleChoiche.getAction().getClass().getName().contains("Attack")) {
                        System.out.println("attacco");
                        party = AttackService.useAttack(party, singleChoiche);
                    } else if (singleChoiche.getAction().getClass().getName().contains("Magic")) {
                        System.out.println("magia");
                        party = MagicService.useMagic(party, singleChoiche);
                    }
                }

            }
        }
        // se invece il sender è morto prima di potere attaccare salterà l'attacco e verra scritto ciò
        else if(singleChoiche.getSender().isDead() == true) {
            System.out.println(singleChoiche.getSender().getName() + " è caduto in battaglia in questo turno" +
                    ", e non può eseguire l'azione");
        }
        // TODO
        // qui ci andrebbe in teoria tutti i calcoli per la meccanica della purificazione e della
        // scelta dei target sui nemici morti, ma per il momento si eseguono gli attacchi e basta,
        // tanto se non può attacare nemici morti finisce x forza sopra
        else {
            System.out.println(singleChoiche.getAction().getName() + " used by " + singleChoiche.getSender().getName() + " to " + singleChoiche.getListOfTargets());
            if (singleChoiche.getAction().getClass().getName().contains("Attack")) {
                System.out.println("attacco");
                party = AttackService.useAttack(party, singleChoiche);
                // metodo controllo se pg è morto o meno dopo calcolo danni
            } else if (singleChoiche.getAction().getClass().getName().contains("Magic")) {
                System.out.println("magia");
                party = MagicService.useMagic(party, singleChoiche);
                // metodo controllo se pg è morto o meno dopo calcolo danni
            }
        }
        return party;
    }
}
