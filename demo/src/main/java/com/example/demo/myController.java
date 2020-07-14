package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class myController {

    private BufferedWriter loadMsgIntoBuffer = null;
    private FileWriter user;

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/doMore")
    public int doAddition(@RequestParam(value = "n1", defaultValue = "8")int n1,@RequestParam(value = "n2")int n2 ){

        if( n1 + n2 > 10){
            return n1+n2;
        }
        return 0;

    }

    @GetMapping("/startgame")
    public void startGame(){
        addMessageToPingPongFile("Ping");
        System.out.println("Ping");
    }

    @GetMapping("/hit")
    public void hit(){
        addMessageToPingPongFile("Pong");
    }

    public void addMessageToPingPongFile(String message){
        try{
            user = new FileWriter("PingPong.txt",true);
            loadMsgIntoBuffer = new BufferedWriter(user);
            loadMsgIntoBuffer.append(message);
            loadMsgIntoBuffer.newLine();
            loadMsgIntoBuffer.flush();
            loadMsgIntoBuffer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
