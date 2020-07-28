package com.smeetshah.pingponggame;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.Charset;


public class PingPongGame {

    private GameConfig gameConfig;
    private ScoreCard[] scoreBoard;

    public PingPongGame(GameConfig gameConfig){
        this.gameConfig = gameConfig;
        scoreBoard = new ScoreCard[gameConfig.getRoundsPerGame()];
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

            rounds[roundCounter] = new GameRound(gameConfig.getMaxShotsPerRound(),gameConfig.getTeams());
            scoreBoard[roundCounter] = rounds[roundCounter].play();

            roundCounter++;
        }

        FileWriter finalScore = new FileWriter("PingPongFinal.txt");
        BufferedWriter loadFinal = new BufferedWriter(finalScore);

        for(int i = 0; i < gameConfig.getRoundsPerGame(); i++){
            loadFinal.write("Round: " + (i+1) + "\n");
            loadFinal.write("=======================================\n");
            loadFinal.write(gameConfig.getTeams()[0].getName()+ ": " + scoreBoard[i].getScoreTeamOne() + "\n");
            loadFinal.write(gameConfig.getTeams()[1].getName()+ ": " + scoreBoard[i].getScoreTeamTwo() + "\n");
            loadFinal.write("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        }

        loadFinal.flush();
        loadFinal.close();

    }

    public void getScores(){

    }



}
