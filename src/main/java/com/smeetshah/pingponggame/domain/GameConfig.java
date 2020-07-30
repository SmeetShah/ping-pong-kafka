package com.smeetshah.pingponggame.domain;

import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;

public class GameConfig {
    private int roundsPerGame;
    private int maxShotsPerRound;
    private KafkaTemplate<String,String> kafkaTemplate;
    private String kafkaTopic;

    public GameConfig(int roundsPerGame, int maxShotsPerRound, KafkaTemplate<String,String> kafkaTemplate, String kafkaTopic){
        this.roundsPerGame = roundsPerGame;
        this.maxShotsPerRound = maxShotsPerRound;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopic = kafkaTopic;
    }

    public int getRoundsPerGame() {
        return roundsPerGame;
    }

    public KafkaTemplate<String, String> getKafkaTemplate() {
        return kafkaTemplate;
    }

    public String getKafkaTopic() {
        return kafkaTopic;
    }

    public int getMaxShotsPerRound() {
        return maxShotsPerRound;
    }

}
