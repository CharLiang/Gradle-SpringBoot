
package com.charles.financialhealth.customerconversation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotation.GenericGenerator;

import static com.charles.financialhealth.customerconversation.util.CCTConstants.JourneyStatus;
import static com.charles.financialhealth.customerconversation.util.CCTConstants.GoalStatus;

@Entity
@Table(name="CCT_JOURNEY")
public class Journey extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column (name = "JOURNEY_ID")
    private String journeyId;

    @Column(name="TILE_SELECTED")
    @Lob
    private String tileSelected;

    @Column(name="GOALS_VIEWED")
    @Lob
    private String goalsViewed;

    @Column (name="ECN")
    private String ecn;

    @Column(name="JOURNEY_STATUS")
    @Enumerated (EnumType.STRING)
    private JourneyStatus journeyStatus;

    @Column(name="GOAL_STATUS")
    @Enumerated (EnumType.STRING)
    private GoalStatus goalStatus;

    @OneToMany(mappedBy = "journey")
    private List<JourneyQuestion> journeyQuestion;

    @OneToMany (mappedBy = "journey", cascade = CascadeType.ALL)
    private List<JourneyTip> journeyTip

    @OneToMany (mappedBy = "journey")
    private List<JourneyDetail> journeyDetail;

    @OneToMany (mappedBy = "journey", cascade = CascadeType.ALL)
    private List<JourneyBanker> journeyBanker;


}
















