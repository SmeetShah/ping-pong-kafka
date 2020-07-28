package com.smeetshah.pingponggame;

public class GameConfig {
    private final int roundsPerGame;
    private final int maxShotsPerRound;
    private final Team teams[] = new Team[2];

    public GameConfig(int roundsPerGame, int maxShotsPerRound, String teamOneName, String teamTwoName, int teamSize){
        this.roundsPerGame = roundsPerGame;
        this.maxShotsPerRound = maxShotsPerRound;
        this.teams[0] = new Team(teamOneName,teamSize);
        this.teams[1] = new Team(teamTwoName,teamSize);
    }

    public int getRoundsPerGame() {
        return roundsPerGame;
    }

    public int getMaxShotsPerRound() {
        return maxShotsPerRound;
    }

    public Team[] getTeams(){
        return teams;
    }


}
