package com.smeetshah.pingponggame;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private int teamSize;
    private List<Player> players;

    public Team(String name, int teamSize){

        this.name = name;
        this.teamSize = teamSize;
        players = new ArrayList<Player>();

    }

    public String getName() {
        return name;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player p){
        if(this.players.size() < teamSize) this.players.add(p);
    }

    public void removePlayer(Player p){
        this.players.remove(p);
    }

}
