package com.smeetshah.pingponggame;

import org.junit.jupiter.api.Test;

public class TeamTest {

    public Team dummyTeam;

    @Test
    public void shouldTeamWithSizeOne(){
        dummyTeam = new Team("team1",1);
    }

}
