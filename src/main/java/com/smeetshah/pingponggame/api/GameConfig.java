package com.smeetshah.pingponggame.api;

public class GameConfig {

    private final int roundsPerGame;
    private final int maxShotsPerRound;
    private final int playerLimitEachTeam;

    public GameConfig(int roundsPerGame, int maxShotsPerRound, int playerLimitEachTeam) {
        this.roundsPerGame = roundsPerGame;
        this.maxShotsPerRound = maxShotsPerRound;
        this.playerLimitEachTeam = playerLimitEachTeam;
    }

    public int getRoundsPerGame() {
        return roundsPerGame;
    }

    public int getMaxShotsPerRound() {
        return maxShotsPerRound;
    }

    public int getPlayerLimitEachTeam() {
        return playerLimitEachTeam;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "roundsPerGame=" + roundsPerGame +
                ", maxShotsPerRound=" + maxShotsPerRound +
                '}';
    }
}
