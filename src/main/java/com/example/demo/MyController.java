package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class MyController {

    private FileMessageAppender fileMsgAppender;

    public MyController(FileMessageAppender fileMsgAppender){
        this.fileMsgAppender = fileMsgAppender;
    }

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
        fileMsgAppender.addMessage("Ping");
        System.out.println("Ping");
    }

    @GetMapping("/hit")
    public void hit(){
        fileMsgAppender.addMessage("Pong");
    }



}
