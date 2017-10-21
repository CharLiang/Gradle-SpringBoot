package com.charles.financialhealth.customerconversation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.charles.financialhealth.customerconversation.entity.Journey;


public interface JourneyRepository extends JpaRepository<Journey, Integer> {
    public Journey findJourneyByJourneyId (String journeyId);
    @Query("select j from Journey j where j.ecn =?1 and j.goalStatus != null order by j.lastModifiedDate desc")
    public List<Journey> findByEcnOrderByLastModifiedDateDesc(String ecn);
    public List<Journey> findByJourneyId(String journeyId);

}












