package com.smeetshah.pingponggame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GameConfig {
    private final int roundsPerGame;
    private final int maxShotsPerRound;
    private final int teamSize;
    private final List<Team> teams;

    public GameConfig(int roundsPerGame, int maxShotsPerRound, String teamOneName, String teamTwoName, int teamSize){
        this.roundsPerGame = roundsPerGame;
        this.maxShotsPerRound = maxShotsPerRound;
        this.teamSize = teamSize;
        teams = new ArrayList<Team>();
        teams.add(new Team(teamOneName,teamSize));
        teams.add(new Team(teamTwoName,teamSize));
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getRoundsPerGame() {
        return roundsPerGame;
    }

    public int getMaxShotsPerRound() {
        return maxShotsPerRound;
    }

    public List<Team> getTeams(){
        return teams;
    }


}
