package com.smeetshah.pingponggame;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;


public class PingPongGame {

    public Team[] teams = new Team[2];
    public GameConfig gameConfig;

    public PingPongGame(String team1, String team2, int teamSize){

        this.teams[0] = new Team(team1,teamSize);
        this.teams[1] = new Team(team2,teamSize);
        gameConfig = new GameConfig();

    }

    public void start(){

        FileWriter moveLogger;

        try {

            moveLogger = new FileWriter("PingPong.txt");

        } catch (IOException e) {

        }

    }


    public void nextMove() throws IOException {

        FileWriter moveLogger = new FileWriter("PingPong.txt",true);
        BufferedWriter loadMoveIntoBuffer = new BufferedWriter(moveLogger);

        String endMsg = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());;

        if(endMsg.endsWith("Ping"+System.lineSeparator())){
            loadMoveIntoBuffer.append("Pong"+System.lineSeparator());
        }else if(endMsg.endsWith("Pong"+System.lineSeparator()) || endMsg.isEmpty()){
            loadMoveIntoBuffer.append("Ping"+System.lineSeparator());
        }

        loadMoveIntoBuffer.flush();
        loadMoveIntoBuffer.close();

    }



}
