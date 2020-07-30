package com.smeetshah.pingponggame.api;

public class GameConfig {

    private final int roundsPerGame;
    private final int maxShotsPerRound;

    public GameConfig(int roundsPerGame, int maxShotsPerRound) {
        this.roundsPerGame = roundsPerGame;
        this.maxShotsPerRound = maxShotsPerRound;
    }

    public int getRoundsPerGame() {
        return roundsPerGame;
    }

    public int getMaxShotsPerRound() {
        return maxShotsPerRound;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "roundsPerGame=" + roundsPerGame +
                ", maxShotsPerRound=" + maxShotsPerRound +
                '}';
    }
}
