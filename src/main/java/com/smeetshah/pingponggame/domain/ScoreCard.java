package com.smeetshah.pingponggame.domain;

public class ScoreCard {

    private int scoreTeamOne;
    private int scoreTeamTwo;

    public ScoreCard() {
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
        if(scoreTeamOne > 0) {
            this.scoreTeamOne += scoreTeamOne;
        }else throw new NegativeScoreAddedToTheTeamException();
    }

    public void setScoreTeamTwo(int scoreTeamTwo) {
        if(scoreTeamTwo > 0){
            this.scoreTeamTwo += scoreTeamTwo;
        }else throw new NegativeScoreAddedToTheTeamException();
    }

    @Override
    public String toString() {
        return "scoreTeamOne=" + scoreTeamOne +
                ", scoreTeamTwo=" + scoreTeamTwo;
    }

}
