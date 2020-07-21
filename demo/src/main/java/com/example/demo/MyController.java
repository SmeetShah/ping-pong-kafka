package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MyController {

    private PingPongGame game;

    @GetMapping("/startgame")
    public void startGame() throws IOException {
        game = new PingPongGame();
    }

    @GetMapping("/nextMove")
    public void nextMove() throws IOException {
        game.nextMove();
    }



}
