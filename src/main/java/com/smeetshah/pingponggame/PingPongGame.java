package com.smeetshah.pingponggame;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.Charset;


public class PingPongGame {

    private GameConfig gameConfig;
    private ScoreCard[] scoreBoard;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private final static int TEAMS = 2;

    public PingPongGame(GameConfig gameConfig, KafkaTemplate<String,String> kafkaTemplate){
        this.gameConfig = gameConfig;
        this.kafkaTemplate = kafkaTemplate;
        scoreBoard = new ScoreCard[gameConfig.getRoundsPerGame()];
    }

    public void addPlayerToTheRespectiveTeams(Player[] players){
        for(int i = 0;i < TEAMS; i++){
            for(int j = i; j < i+gameConfig.getTeamSize(); j++){
                gameConfig.getTeams().get(i).addPlayer(players[j]);
            }
        }
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
            loadFinal.write(gameConfig.getTeams().get(0).getName()+ ": " + scoreBoard[i].getScoreTeamOne() + "\n");
            loadFinal.write(gameConfig.getTeams().get(1).getName()+ ": " + scoreBoard[i].getScoreTeamTwo() + "\n");
            loadFinal.write("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        }

        loadFinal.flush();
        loadFinal.close();

    }

    public void getScores(){

    }



}
