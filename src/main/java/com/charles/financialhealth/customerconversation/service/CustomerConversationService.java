package com.charles.financialhealth.customerconversation.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.Marker;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.charles.financialhealth.customerconversation.entity.Tile;
import com.charles.financialhealth.customerconversation.entity.Goal;
import com.charles.financialhealth.customerconversation.view.GoalTiles;
import static com.charles.financialhealth.customerconversation.util.CCTConstants.*;

import com.charles.financialhealth.customerconversation.repository.JourneyBankerRepository;



@Service
public class CustomerConversationService extends CCTBaseService {
    
    private static final Logger log = LogManager.getLogger (CustomerConversationService.class);
    private static final Marker APP_MARKER = MarketManager.getMarker("application");

    @Autowired
    private GoalRepository goalRepositry;
    @Autowired
    private TilesRepositories tilesRepositories;
    @Autowired
    private QuestionRepositories questionRepositories;
    @Autowired
    private QuestionOptionRepository questionOptionRepository;
    @Autowired
    private QuestionInputMapperRepository questionInputMapperRepository;
    @Autowired
    private OptionTipRepository optionTipRepository;
    @Autowired
    private JourneyBankerRepository journeyBankerRepository;
    @Autowired
    private JourneyQuestionRepository journeyQuestionRepository;
    @Autowired
    private JourneyTipRepository journeyTipRepository;
    @Autowired
    private JourneyDetailRepository journeyDetailRepository;

    /**
        Method will fetch all the goals and their corresponding tiles from database and return to the front end API call.
        this is the first calll or entry point on the application flow.
     */

    public List<GoalTiles> fetchGoals(){
        List<GoalTiles> goalTiles = new ArrayList<>();
        List<Goal> goalList = goalRepository.findAll();

        goalList.forEach(goal -> {
            GoalTiles goalTile = new GoalTiles();
            goalTile.setGoalId(goal.getGoalId());
            goalTile.setName(goal.getLabel());
            goalTile.setImgPath(goal.getImagePath());

            List<GoalTiles.Tile> goal_t_list = new ArrayList<>();
            List<Tile> tipTiles = tilesRepositories.findByGoal(goal);
            tipTiles.forEach( tile -> {
                GoalTiles.Tile goal_t = new GoalTiles.Tile();
                goal_t.setTileId(tile.getId());
                goal_t.setTileName(tile.getName());
                goal_t.setTileImg(tile.getImagePath());
                goal_t_list.add(goal_t);
            });

            goalTile.setGoalTilesList(goal_t_list);
            goalTiles.add(goalTile);


        })
        return goalTiles;

    }

    /**
        create customer journey for the tile presented. This is the method which is responsible for 
        creating the Journey Id on the landing page and returns to client to communicate with client 
        in all subsequent request.
    
      *  @return Auto generate Journey Id
     */

    public String createCustomerJourney (QueryParameters queryParameters) {
        Journey journey = new Journey();
        Journey.setEcn(queryParameters.getEcn());
        journeyRepository.save(journey);
        JourneyBanker.JourneyBankerPK pk1 = new JourneyBanker.JourneyBankerPK(queryParameters.getBankerid(), journey.getJourneyId());
        JourneyBanker journeyBanker = new JourneyBanker(pk1, journey);
        journeyBankerRepository.save(journeyBanker);

        updateJourneyStatus(journey, CCTConstants.JourneyStatus.STARTED);
        return journey.getJourneyId();
    }












}







