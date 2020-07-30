package com.smeetshah.pingponggame.domain;

import com.smeetshah.pingponggame.domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player dummyPlayer;

    @Test
    public void shouldCreatePlayerWithNameSmeetAndSLRookie(){
        dummyPlayer = new Player("Smeet", Player.SkillLevel.ROOKIE);

        Assertions.assertEquals("Smeet",dummyPlayer.getName());
        Assertions.assertEquals(Player.SkillLevel.ROOKIE,dummyPlayer.getSkillLevel());
    }

    @Test
    public void shouldUpgradePlayerToProfessional(){
        dummyPlayer = new Player("Smeet", Player.SkillLevel.ROOKIE);

        dummyPlayer.upgradeSkillLevel(Player.SkillLevel.PROFESSIONAL);

        Assertions.assertEquals(Player.SkillLevel.PROFESSIONAL,dummyPlayer.getSkillLevel());
    }

    @Test
    public void shouldNotHavePlayerAtProfessional(){
        dummyPlayer = new Player("Smeet", Player.SkillLevel.ROOKIE);

        Assertions.assertEquals(Player.SkillLevel.PROFESSIONAL,dummyPlayer.getSkillLevel());
    }


}
