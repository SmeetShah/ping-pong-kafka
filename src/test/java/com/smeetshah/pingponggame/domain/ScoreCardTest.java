package com.smeetshah.pingponggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCardTest {

    @Test
    public void shouldCreateScoreCardWithInitialScoreOfZero(){
        ScoreCard scoreCard = new ScoreCard();

        Assertions.assertEquals(0,scoreCard.getScoreTeamOne());
        Assertions.assertEquals(0,scoreCard.getScoreTeamTwo());
    }

    @Test
    public void shouldAddScoreToEachTeam(){
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.setScoreTeamOne(1);
        scoreCard.setScoreTeamTwo(1);

        Assertions.assertEquals(1,scoreCard.getScoreTeamOne());
        Assertions.assertEquals(1,scoreCard.getScoreTeamTwo());
    }

    @Test
    public void shouldNotAllowNegativeScoreToBeAdded(){
        ScoreCard scoreCard = new ScoreCard();

        Assertions.assertThrows(NegativeScoreAddedToTheTeamException.class,() -> {scoreCard.setScoreTeamOne(-1);});
    }

}
