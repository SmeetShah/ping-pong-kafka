package com.smeetshah.pingponggame.domain;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Logger;

public class ScoreCard {

    private int scoreTeamOne;
    private int scoreTeamTwo;
    private Logger log;

    public ScoreCard(){
        scoreTeamOne = 0;
        scoreTeamTwo = 0;
    }

    public int getScoreTeamOne() {
        return scoreTeamOne;
    }

    public int getScoreTeamTwo() {
        return scoreTeamTwo;
    }

    public void updateScoreCard(int team){
        if(team == 1) scoreTeamOne++;
        if(team == 2) scoreTeamTwo++;
    }

    @KafkaListener(topics = "mytopic", groupId = "group-id")
    public void receive(String message){
        if(message.endsWith("t1")){
            scoreTeamOne++;
        }else if(message.endsWith("t2")){
            scoreTeamTwo++;
        }
       System.out.println("Received:" + message);
    }


}
