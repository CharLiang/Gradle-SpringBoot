package com.wellsfargo.financialhealth.customerconversation.view;


import javax.validation.constraints.NotNull;


public class BaseAttributeView {
    @NotNull
    private String journeyId;

    public String getJourneyId(){
      return journeyId;
    }
    public void setJourneyId (String journeyId){
      this.journeyId = journeyId;
    }
  
}









