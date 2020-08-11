package com.smeetshah.pingponggame.domain;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GameListener {

    @KafkaListener(topics = "mytopic", groupId = "group-id")
    public void receive(String message) {
        if (message.endsWith("1")) {
            GameRound.roundScoreCard.setScoreTeamOne(1);
            //System.out.println("Received: Score to team 1 ->" + message);
        } else if (message.endsWith("2")) {
            GameRound.roundScoreCard.setScoreTeamTwo(1);
            //System.out.println("Received: Score to team 2 ->" + message);
        }
    }

}
