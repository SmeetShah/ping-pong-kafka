package com.smeetshah.pingponggame.domain;

import org.springframework.kafka.core.KafkaTemplate;

import java.util.Objects;

public class GameConfig {
    private int roundsPerGame;
    private int maxShotsPerRound;
    private KafkaTemplate<String, String> kafkaTemplate;
    private String kafkaTopic;
    private int playerLimitEachTeam;

    public GameConfig(int roundsPerGame, int maxShotsPerRound,int playerLimitEachTeam, KafkaTemplate<String, String> kafkaTemplate, String kafkaTopic) {
        this.roundsPerGame = roundsPerGame;
        this.maxShotsPerRound = maxShotsPerRound;
        this.playerLimitEachTeam = playerLimitEachTeam;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopic = kafkaTopic;
    }

    public int getPlayerLimitEachTeam() {
        return playerLimitEachTeam;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameConfig that = (GameConfig) o;
        return roundsPerGame == that.roundsPerGame &&
                maxShotsPerRound == that.maxShotsPerRound &&
                playerLimitEachTeam == that.playerLimitEachTeam &&
                Objects.equals(kafkaTemplate, that.kafkaTemplate) &&
                Objects.equals(kafkaTopic, that.kafkaTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundsPerGame, maxShotsPerRound, kafkaTemplate, kafkaTopic, playerLimitEachTeam);
    }
}
