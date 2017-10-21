package com.wellsfargo.financialhealth.customerconversation.view;

import java.util.Collection;

public class GoalTiesView extends BaseAttributeView {

  public Collection<GoalTiles> goalTiles;

  public Collection<GoalTiles> getGoalTiles() {
    return goalTiles;
  }

  public void setGoalTiles (Collection<GoalTiles> goalTiles) {
    this.goalTiles = goalTiles;
  }

  @Override
  public String toString(){
    return "[journeyId=" + getJourneyId() + ", goalAndTiles=" + getGoalTiles()+ "]";
  }


}





