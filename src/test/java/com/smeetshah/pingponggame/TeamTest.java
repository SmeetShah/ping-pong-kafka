package com.smeetshah.pingponggame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamTest {

    public Team dummyTeam;
    private Player dummyPlayer = new Player("Smeet", Player.SkillLevel.ROOKIE);
    private Player dummyPlayer1 = new Player("Matt", Player.SkillLevel.PROFESSIONAL);

    @Test
    public void shouldCreateTeamWithSizeOne(){
        dummyTeam = new Team("team1",1);

        Assertions.assertEquals(1,dummyTeam.getTeamSize());
    }

    @Test
    public void shouldAddPlayerInTeam(){

        dummyTeam = new Team("team1",1);
        dummyTeam.addPlayer(dummyPlayer);

        Player[] players = dummyTeam.getPlayers();

        Assertions.assertEquals(dummyPlayer,players[0]);

    }

    @Test
    public void shouldNotAllowSecondPlayerInTeamWithSizeOne(){

        dummyTeam = new Team("team1",1);
        dummyTeam.addPlayer(dummyPlayer);
        dummyTeam.addPlayer(dummyPlayer1);

        Assertions.assertEquals(1,dummyTeam.getPlayers().length);

    }

    @Test
    public void shouldRemovePlayerFromTeam(){

        dummyTeam = new Team("team1",1);

        dummyTeam.addPlayer(dummyPlayer);
        dummyTeam.removePlayer(dummyPlayer);

        Assertions.assertEquals(0,dummyTeam.getPlayers().length);

    }


    @Test
    public void shouldHave2Teams(){

        Team[] dummyTeams = new Team[2];
        dummyTeams[0] = new Team("team1",1);
        dummyTeams[1] = new Team("team1",1);

        Assertions.assertEquals(2,dummyTeams.length);

    }

}
