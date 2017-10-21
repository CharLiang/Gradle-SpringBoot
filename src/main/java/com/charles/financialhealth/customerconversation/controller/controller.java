package com.charles.financialhealth.customerconversation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import com.charles.financialhealth.customerconversation.service.CustomerConversationService;
import com.charles.financialhealth.customerconversation.service.JourneyVisualizerService;
import com.charles.financialhealth.customerconversation.servic.RWSService;

import com.charles.financialhealth.customerconversation.view.GoalTilesView;
import com.charles.financialhealth.customerconversation.view.QueryParameters;



@RequestController
@RequestMapping("/api")
public class CCTController {

  public static final Logger log = LogManager.getLogger(CCTController.class);
  private static final Marker APP_MARKER = MarketManager.getMarker("application");
  private JourneyVisualizerService journeyVisualizerService;
  private RWSService rWSService;


  @Autowired
  private ServletContext serveletContext;

  @Autowired
  private CustomerFormsService serImpl;

  public CCTController (JourneyVisualizerService journeyVisualizer, CustomerFormsService customerFormsService, RWSService rWSService){
      this.journeyVisualizer = journeyVisualizer;
      this.customerFormsSerice = customerFormsService;
      this.rWSService = rWSService;
  }


  @RequestMapping(  method = RequestMethod.GET,
                    value = "/goals",
                    produce = MediaType.APPLICATION_JSON_VALUE)

  public GoalTilesView getGoals(  @Valid @RequestParam("ecn") String ecn, 
                                  @RequestHeader(required = true, value = "cssamaccountname") String BANKER_ID ){
  
      log.info(APP_MARKER, "Request - getGoals : ecn "+ ecn + ", banker_id: "+ BANKER_ID);
      QueryParameters queryParameters = new QueryParameters();
      queryParameters.setEcn(ecn);
      queryParameters.setBankerid (BANKER_ID);  
      log.info(APP_MARKER, "The banker_id from the channel secure is: "+ BANKER_ID);

      // create the journey when fetch the goals on landing page
      String journeyId = customerConversationService.createCustomerJourney (queryParameteres);
      GoalTilesView goalTilesView = new GoalTilesView();
      goalTilesView.setJourneyId (journeyId);
      goalTilesView.setGoalTiles (customerConversationService.fetchGoals());

      return goalTilesView;
  }


}
