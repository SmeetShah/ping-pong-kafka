package com.example.demo;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class FileMessageAppender {

    private BufferedWriter loadMsgIntoBuffer = null;
    private FileWriter fileWriter;

    public void createNewGame() throws IOException {
        File newGameFile = new File("PingPong.txt");
        newGameFile.createNewFile();
    }

    public void addMessage(String message){

        try{
            fileWriter = new FileWriter("PingPong.txt",true);
            loadMsgIntoBuffer = new BufferedWriter(fileWriter);
            loadMsgIntoBuffer.append(message);
            loadMsgIntoBuffer.newLine();
            loadMsgIntoBuffer.flush();
            loadMsgIntoBuffer.close();
        }catch(IOException e){

        }

    }

    public void nextMessage() throws IOException {
        String endMsg = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());;

        if(endMsg.endsWith("Ping"+System.lineSeparator())){
            addMessage("Pong");
        }else if(endMsg.endsWith("Pong"+System.lineSeparator()) || endMsg.isEmpty()){
            addMessage("Ping");
        }

    }


}
