package org.ht.rpg.game.utils;

import java.util.List;

public class ChoicheUtils {

    private int idSender;
    private int idAction;
    private List<Integer> listOfTargets;


    //per vedere se ha priorita o meno una determinata azione es fuga,attacco rapido
    private boolean isActionPriority;
    private boolean isActionInversePriority;

    public ChoicheUtils() {
    }

    public ChoicheUtils(int idSender, int idAction, List<Integer> listOfTargets, boolean isActionPriority, boolean isInversedPriority) {
        this.idSender = idSender;
        this.idAction = idAction;
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

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
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
