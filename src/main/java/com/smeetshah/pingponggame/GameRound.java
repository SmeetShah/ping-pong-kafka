package com.smeetshah.pingponggame;

import java.io.IOException;
import java.util.Random;

public class GameRound {

    private int shotsLimit;
    private Team[] teams;

    public GameRound(int shotsLimit, Team[] teams){
        this.shotsLimit = shotsLimit;
        this.teams = teams;
    }

    public ScoreCard play() throws IOException {

        //for time being we will start with random team starting almost like Toss to decide
        Random generateRand = new Random();
        int shotCounter = 0;
        int teamToServe = generateRand.nextInt(2);
        ScoreCard roundScore = new ScoreCard();

        while(shotCounter < shotsLimit){

            if(shotCounter == 0 ){
                teams[teamToServe].getPlayers()[generateRand.nextInt(teams[0].getTeamSize())].serve();
            }else {
                teams[teamToServe].getPlayers()[generateRand.nextInt(teams[0].getTeamSize())].receive();
            }

            teams[teamToServe].getPlayers()[generateRand.nextInt(teams[0].getTeamSize())].txtFileLogger();

            roundScore.updateScoreCard(teamToServe+1);

            if(teamToServe == 1){
                teamToServe = 0;
            }else {
                teamToServe = 1;
            }

            shotCounter++;
        }

        return roundScore;
    }

}
