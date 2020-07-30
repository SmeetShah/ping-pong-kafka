package com.smeetshah.pingponggame.domain;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GameRound {

    private GameConfig gameConfig;
    private List<Team> teams;
    private int teamSize;
    public static ScoreCard roundScoreCard;


    public GameRound(GameConfig gameConfig, List<Team> teams){
        this.gameConfig = gameConfig;
        this.teamSize = teams.size();
        this.teams = teams;
        roundScoreCard = new ScoreCard();
    }

    public ScoreCard play() throws IOException {

        //for time being we will start with random team starting almost like Toss to decide
        Random generateRand = new Random();
        int shotCounter = 0;
        int teamToServe = generateRand.nextInt(teams.size());
        int playersPerTeam;

        while(shotCounter < gameConfig.getMaxShotsPerRound()){

            String msg;
            if(shotCounter % 2 == 0){
                msg = "pingt" + String.valueOf(teamToServe + 1);
            }else {
                msg = "pongt" + String.valueOf(teamToServe + 1);
            }

            playersPerTeam = teams.get(teamToServe).getPlayers().size();

            Player tempPlayer = teams.get(teamToServe).getPlayers().get(generateRand.nextInt(playersPerTeam));

            tempPlayer.stroke(gameConfig.getKafkaTemplate(),gameConfig.getKafkaTopic(),msg);

            //teams[teamToServe].getPlayers()[generateRand.nextInt(teams[0].getTeamSize())].txtFileLogger();

            //roundScore.updateScoreCard(teamToServe+1);

            if(teamToServe == 1){
                teamToServe = 0;
            }else {
                teamToServe = 1;
            }

            shotCounter++;
        }

        return roundScoreCard;
    }


}
