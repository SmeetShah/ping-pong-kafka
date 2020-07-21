package com.smeetshah.pingponggame;

import java.util.ArrayList;

public class Team {
    public String name;
    public int teamSize;
    public ArrayList<Player> players;

    public Team(String name, int teamSize){

        this.name = name;
        this.teamSize = teamSize;
        players = new ArrayList<Player>();

    }

    public String getName() {
        return name;
    }

    public Player[] getPlayers(){
        Player[] listOfPlayers = new Player[this.players.size()];

        for(int i = 0; i < this.players.size(); i++) {
            listOfPlayers[i] = this.players.get(i);
        }

        return listOfPlayers;
    }

    public void addPlayer(Player p){
        if(this.players.size() <= teamSize) this.players.add(p);
    }

    public void removePlayer(Player p){
        this.players.remove(p);
    }

}
