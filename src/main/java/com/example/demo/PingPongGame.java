package com.example.demo;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;


public class PingPongGame {

    private BufferedWriter loadMoveIntoBuffer = null;
    private FileWriter moveLogger;

    public PingPongGame(){

        try {
            moveLogger = new FileWriter("PingPong.txt");
        } catch (IOException e) {

        }
    }

    public void nextMove() throws IOException {
        String endMsg = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());;

        if(endMsg.endsWith("Ping"+System.lineSeparator())){
            logMove("Pong");
        }else if(endMsg.endsWith("Pong"+System.lineSeparator()) || endMsg.isEmpty()){
            logMove("Ping");
        }

    }

    private void logMove(String message){

        try{
            moveLogger = new FileWriter("PingPong.txt",true);
            loadMoveIntoBuffer = new BufferedWriter(moveLogger);
            loadMoveIntoBuffer.append(message);
            loadMoveIntoBuffer.newLine();
            loadMoveIntoBuffer.flush();
            loadMoveIntoBuffer.close();
        }catch(IOException e){

        }

    }


}
