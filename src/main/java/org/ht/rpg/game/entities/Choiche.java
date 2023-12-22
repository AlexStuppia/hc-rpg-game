package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Action;

import java.util.List;

public class Choiche {

    private Fighter sender;
    private Action action;
    private List<Fighter> listOfTargets;


    //per vedere se ha priorita o meno una determinata azione es fuga,attacco rapido
    private boolean isActionPriority;
    private boolean isActionInversePriority;

    public Choiche() {
    }

    public Choiche(Fighter sender, Action action, List<Fighter> listOfTargets, boolean isActionPriority, boolean isInversedPriority) {
        this.sender = sender;
        this.action = action;
        this.listOfTargets = listOfTargets;
        this.isActionPriority = isActionPriority;
        this.isActionInversePriority = isInversedPriority;
    }

    public Fighter getSender() {
        return sender;
    }

    public void setSender(Fighter sender) {
        this.sender = sender;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Fighter> getListOfTargets() {
        return listOfTargets;
    }

    public void setListOfTargets(List<Fighter> listOfTargets) {
        this.listOfTargets = listOfTargets;
    }

    public boolean isActionPriority() {
        return isActionPriority;
    }

    public void setActionPriority(boolean actionPriority) {
        isActionPriority = actionPriority;
    }

    public boolean isActionInversePriority() {
        return isActionInversePriority;
    }

    public void setActionInversePriority(boolean actionInversePriority) {
        isActionInversePriority = actionInversePriority;
    }

}
