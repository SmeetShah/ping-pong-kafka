package com.smeetshah.pingponggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Team {
    private String name;
    private List<Player> players;
    private int playerLimitEachTeam;

    public Team(String name, int playerLimitEachTeam) {
        this.name = name;
        this.playerLimitEachTeam = playerLimitEachTeam;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        if (players.size() >= playerLimitEachTeam) {
            throw new TeamPlayerLimitReachedException();
        }
        this.players.add(p);
    }

    public void removePlayer(Player p) {
        if (players.size() == 0) {
            throw new NoPlayerExistInTheTeamException();
        }
        if (!players.contains(p)) {
            throw new PlayerDoesNotBelongToTheTeamException();
        }
        players.remove(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return playerLimitEachTeam == team.playerLimitEachTeam &&
                Objects.equals(name, team.name) &&
                Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, players, playerLimitEachTeam);
    }
}
