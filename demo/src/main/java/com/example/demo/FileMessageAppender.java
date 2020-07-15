package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileMessageAppender {

    private BufferedWriter loadMsgIntoBuffer = null;
    private FileWriter fileWriter;

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

}
