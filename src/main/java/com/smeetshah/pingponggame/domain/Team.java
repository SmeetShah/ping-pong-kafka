package com.smeetshah.pingponggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name){

        this.name = name;
        players = new ArrayList<Player>();

    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player p){
        this.players.add(p);
    }

    public void removePlayer(Player p){
        this.players.remove(p);
    }

}
