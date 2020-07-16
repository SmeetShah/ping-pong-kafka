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

    @GetMapping("/startgame")
    public void startGame() throws IOException {
        fileMsgAppender.createNewGame();
    }

    @GetMapping("/hit")
    public void hit() throws IOException {
        fileMsgAppender.nextMessage();
    }



}
