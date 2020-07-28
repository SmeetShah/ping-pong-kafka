package com.smeetshah.pingponggame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRound {

    private int shotsLimit;
    private List<Team> teams;

    public GameRound(int shotsLimit, List<Team> teams){
        this.shotsLimit = shotsLimit;
        this.teams = new ArrayList<>();
        this.teams = teams;
    }

    public ScoreCard play() throws IOException {

        //for time being we will start with random team starting almost like Toss to decide
        Random generateRand = new Random();
        int shotCounter = 0;
        int teamToServe = generateRand.nextInt(2);
        ScoreCard roundScore = new ScoreCard();

        while(shotCounter < shotsLimit){


            String msg;
            if(shotCounter % 2 == 0){
                msg = "pingt" + String.valueOf(teamToServe + 1);
            }else {
                msg = "pongt" + String.valueOf(teamToServe + 1);
            }

            teams.get(teamToServe).getPlayers().get(generateRand.nextInt(teams.get(teamToServe).getTeamSize())).stroke(msg);

            //teams[teamToServe].getPlayers()[generateRand.nextInt(teams[0].getTeamSize())].txtFileLogger();

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
