package com.smeetshah.pingponggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldCreatePlayerWithNameSmeetAndSLRookie(){
        Player player = new Player("Smeet", Player.SkillLevel.ROOKIE);

        Assertions.assertEquals("Smeet", player.getName());
        Assertions.assertEquals(Player.SkillLevel.ROOKIE, player.getSkillLevel());
    }

    @Test
    public void shouldUpgradePlayerToProfessional(){
        Player player = new Player("Smeet", Player.SkillLevel.ROOKIE);

        player.upgradeSkillLevel(Player.SkillLevel.PROFESSIONAL);
        Assertions.assertEquals(Player.SkillLevel.PROFESSIONAL, player.getSkillLevel());
    }

}
