package com.smeetshah.pingponggame;

public class ScoreCard {

    private int scoreTeamOne;
    private int scoreTeamTwo;

    public ScoreCard(){
        scoreTeamOne = 0;
        scoreTeamTwo = 0;
    }

    public int getScoreTeamOne() {
        return scoreTeamOne;
    }

    public int getScoreTeamTwo() {
        return scoreTeamTwo;
    }

    public void updateScoreCard(int team){
        if(team == 1) scoreTeamOne++;
        if(team == 2) scoreTeamTwo++;
    }

}
