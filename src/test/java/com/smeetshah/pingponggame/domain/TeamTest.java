package com.smeetshah.pingponggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamTest {

    private static final Player SMEET = new Player("Smeet", Player.SkillLevel.ROOKIE);
    private static final Player MATT = new Player("Matt", Player.SkillLevel.PROFESSIONAL);

    @Test
    public void shouldCreateTeamWithNoPlayers(){
        Team team = new Team("team1",1);

        Assertions.assertEquals(0,team.getPlayers().size());
    }

    @Test
    public void shouldAddPlayerInTheTeam(){
        Team team = new Team("team1",1);
        team.addPlayer(SMEET);

        Assertions.assertEquals(SMEET,team.getPlayers().get(0));
    }

    @Test
    public void shouldNotAllowSecondPlayerInTeamWithSizeOne(){
        Team team = new Team("team1",1);
        team.addPlayer(SMEET);

        Assertions.assertThrows(TeamPlayerLimitReachedException.class,() -> {team.addPlayer(MATT);});
    }

    @Test
    public void shouldThrowErrorWhileRemovingFromTeamWithNoPlayers(){
        Team team = new Team("team1",1);

        Assertions.assertThrows(NoPlayerExistInTheTeamException.class,() -> {team.removePlayer(SMEET);});
    }


    @Test
    public void shouldAddTwoPlayersToTheTeam(){
        Team team = new Team("team 1",2);
        team.addPlayer(SMEET);

        Assertions.assertDoesNotThrow(() -> {team.addPlayer(MATT);});
    }

    @Test
    public void shouldNotDeletePlayerWhoDontBelongToTheTeam(){
        Team team = new Team("team 1",1);
        team.addPlayer(SMEET);

        Assertions.assertThrows(PlayerDoesNotBelongToTheTeamException.class, () -> {team.removePlayer(MATT);});
    }

}
