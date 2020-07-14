package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileMessageAppender {

    private BufferedWriter loadMsgIntoBuffer = null;
    private FileWriter user;

    public void addMessage(String message){

        try{
            user = new FileWriter("PingPong.txt",true);
            loadMsgIntoBuffer = new BufferedWriter(user);
            loadMsgIntoBuffer.append(message);
            loadMsgIntoBuffer.newLine();
            loadMsgIntoBuffer.flush();
            loadMsgIntoBuffer.close();
        }catch(IOException e){

        }

    }

}
