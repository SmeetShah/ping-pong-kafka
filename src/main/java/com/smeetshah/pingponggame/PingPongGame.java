package com.smeetshah.pingponggame;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.Charset;


public class PingPongGame {

    public Team[] teams = new Team[2];
    public GameConfig gameConfig;
    public ScoreCard[] scoreBoard = new ScoreCard[3];

    public PingPongGame(String team1, String team2, int teamSize){

        this.teams[0] = new Team(team1,teamSize);
        this.teams[1] = new Team(team2,teamSize);
        gameConfig = new GameConfig(3,9);

    }

    public void start() throws IOException {

        FileWriter moveLogger;

        try {

            moveLogger = new FileWriter("PingPong.txt");

        } catch (IOException e) {

        }

        GameRound[] rounds = new GameRound[gameConfig.getRoundsPerGame()];

        int roundCounter = 0;

        while(roundCounter < gameConfig.getRoundsPerGame()){

            rounds[roundCounter] = new GameRound(gameConfig.getMaxShotsPerRound(),teams);
            scoreBoard[roundCounter] = rounds[roundCounter].play();

            roundCounter++;
        }

        FileWriter finalScore = new FileWriter("PingPongFinal.txt");
        BufferedWriter loadFinal = new BufferedWriter(finalScore);

        for(int i = 0; i < gameConfig.getRoundsPerGame(); i++){
            loadFinal.write("Round: " + (i+1) + "\n");
            loadFinal.write("=======================================\n");
            loadFinal.write(teams[0].getName()+ " :" + scoreBoard[i].getScoreTeamOne() + "\n");
            loadFinal.write(teams[1].getName()+ " :" + scoreBoard[i].getScoreTeamTwo() + "\n");
            loadFinal.write("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        }

        loadFinal.flush();
        loadFinal.close();

    }

    public void getScores(){

    }



}
