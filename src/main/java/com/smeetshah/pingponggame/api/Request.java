package com.smeetshah.pingponggame.api;

import java.util.List;

public class Request {
    private GameConfig gameConfig;
    private List<Team> teams;

    public Request(GameConfig config, List<Team> teams){
        this.gameConfig = config;
        this.teams = teams;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
