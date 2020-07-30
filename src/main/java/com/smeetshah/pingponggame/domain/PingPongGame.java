package com.smeetshah.pingponggame.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PingPongGame {

    private GameConfig gameConfig;
    private ScoreCard[] scoreBoard;
    private List<Team> teams;

    public PingPongGame(GameConfig gameConfig, List<Team> teams){
        this.gameConfig = gameConfig;
        scoreBoard = new ScoreCard[gameConfig.getRoundsPerGame()];
        this.teams = teams;
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

            rounds[roundCounter] = new GameRound(gameConfig,teams);
            scoreBoard[roundCounter] = rounds[roundCounter].play();

            roundCounter++;
        }

        FileWriter finalScore = new FileWriter("PingPongFinal.txt");
        BufferedWriter loadFinal = new BufferedWriter(finalScore);

        for(int i = 0; i < gameConfig.getRoundsPerGame(); i++){
            loadFinal.write("Round: " + (i+1) + "\n");
            loadFinal.write("=======================================\n");
            loadFinal.write(teams.get(0).getName()+ ": " + scoreBoard[i].getScoreTeamOne() + "\n");
            loadFinal.write(teams.get(1).getName()+ ": " + scoreBoard[i].getScoreTeamTwo() + "\n");
            loadFinal.write("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        }

        loadFinal.flush();
        loadFinal.close();

    }

    public void getScores(){

    }



}
