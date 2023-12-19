package org.ht.rpg.game.entities;

import org.ht.rpg.game.action.Action;

import java.util.List;

public class Choiche {

    private int idSender;
    private Action action;
    private List<Integer> listOfTargets;


    //per vedere se ha priorita o meno una determinata azione es fuga,attacco rapido
    private boolean isActionPriority;
    private boolean isActionInversePriority;

    public Choiche() {
    }

    public Choiche(int idSender, Action action, List<Integer> listOfTargets, boolean isActionPriority, boolean isInversedPriority) {
        this.idSender = idSender;
        this.action = action;
        this.listOfTargets = listOfTargets;
        this.isActionPriority = isActionPriority;
        this.isActionInversePriority = isInversedPriority;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Integer> getListOfTargets() {
        return listOfTargets;
    }

    public void setListOfTargets(List<Integer> listOfTargets) {
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
