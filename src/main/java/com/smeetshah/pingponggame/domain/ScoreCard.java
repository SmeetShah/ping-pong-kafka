package com.smeetshah.pingponggame.domain;



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

    public void setScoreTeamOne(int scoreTeamOne) {
        this.scoreTeamOne += scoreTeamOne;
    }

    public void setScoreTeamTwo(int scoreTeamTwo) {
        this.scoreTeamTwo += scoreTeamTwo;
    }

    @Override
    public String toString() {
        return "scoreTeamOne=" + scoreTeamOne +
                ", scoreTeamTwo=" + scoreTeamTwo ;
    }


}
