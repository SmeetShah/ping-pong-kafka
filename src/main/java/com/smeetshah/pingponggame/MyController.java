package com.smeetshah.pingponggame;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MyController {

    private PingPongGame game;

    @GetMapping("/startgame")
    public void startGame(@RequestParam String t1, @RequestParam String t2, @RequestParam int ts) throws IOException {
        game = new PingPongGame(t1,t2, ts);
    }

    @GetMapping("/addPlayer")
    public void addPlayerToTeams(){
        game.teams[0].addPlayer(new Player("Smeet", Player.SkillLevel.ROOKIE));
        game.teams[1].addPlayer(new Player("Sonu", Player.SkillLevel.ROOKIE));
    }

    @GetMapping("/nextMove")
    public void nextMove() throws IOException {
        game.start();
    }



}
