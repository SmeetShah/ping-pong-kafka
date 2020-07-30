package com.smeetshah.pingponggame.api;

import java.util.List;

public class Request {
    private GameConfig gameConfig;
    private List<Team> teams;

    public Request(GameConfig gameConfig, List<Team> teams){
        this.gameConfig = gameConfig;
        this.teams = teams;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
