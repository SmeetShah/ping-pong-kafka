package com.smeetshah.pingponggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamTest {

    private static final Player SMEET = new Player("Smeet", Player.SkillLevel.ROOKIE);
    private static final Player MATT = new Player("Matt", Player.SkillLevel.PROFESSIONAL);

    @Test
    public void shouldCreateTeamWithNoPlayers(){
        Team team = new Team("team1");

        Assertions.assertEquals(0,team.getPlayers().size());
    }

    @Test
    public void shouldAddPlayerInTeam(){
        Team team = new Team("team1");
        team.addPlayer(SMEET);

        Assertions.assertEquals(SMEET,team.getPlayers().get(0));
    }

    @Test
    public void shouldNotAllowSecondPlayerInTeamWithSizeOne(){
        Team team = new Team("team1");
        team.addPlayer(SMEET);

        Assertions.assertThrows(TeamPlayerLimitReachedException.class,() -> {team.addPlayer(MATT);});
    }

    @Test
    public void shouldThrowErrorWhileRemovingFromTeamWithNoPlayer(){
        Team team = new Team("team1");

        Assertions.assertThrows(NoPlayerExistInTheTeamException.class,() -> {team.removePlayer(SMEET);});
    }


    @Test
    public void shouldHave2Teams(){

        Team[] dummyTeams = new Team[2];
        dummyTeams[0] = new Team("team1",1);
        dummyTeams[1] = new Team("team1",1);

        Assertions.assertEquals(2,dummyTeams.length);

    }

}
