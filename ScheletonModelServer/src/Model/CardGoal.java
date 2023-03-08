package Model;

import Model.enumeration.CardGoalType;

import java.util.Map;

public class CardGoal extends Card{
    private Shelf layoutToMatch; //La tavola del giocatore deve matchare questo layout (per acquisire punti a seconda della Map legendPoint)
    private Map<Integer, Point> legendPoint;
    private CardGoalType goalType;

    public CardGoal(Shelf layoutToMatch, Map<Integer, Point> legendPoint, CardGoalType goalType) {
        this.layoutToMatch = layoutToMatch;
        this.legendPoint = legendPoint;
        this.goalType = goalType;
    }

    public Shelf getLayoutToMatch() {
        return layoutToMatch;
    }

    public void setLayoutToMatch(Shelf layoutToMatch) {
        this.layoutToMatch = layoutToMatch;
    }

    public Map<Integer, Point> getLegendPoint() {
        return legendPoint;
    }

    public void setLegendPoint(Map<Integer, Point> legendPoint) {
        this.legendPoint = legendPoint;
    }

    public CardGoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(CardGoalType goalType) {
        this.goalType = goalType;
    }
}
