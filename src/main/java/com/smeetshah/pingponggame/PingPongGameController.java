package com.smeetshah.pingponggame;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PingPongGameController {

    private PingPongGame game;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping(value = "/startGame")
    public void startGame(@RequestBody GameConfig gameConfig, @RequestBody Player[] players) throws IOException {
        game = new PingPongGame(gameConfig,kafkaTemplate);
        game.addPlayerToTheRespectiveTeams(players);
    }

    /*@GetMapping("/addPlayer")
    public void addPlayerToTeams(){
        game.teams[0].addPlayer(new Player("Smeet", Player.SkillLevel.ROOKIE, kafkaTemplate));
        game.teams[1].addPlayer(new Player("Sonu", Player.SkillLevel.ROOKIE, kafkaTemplate));
        //log.info("Added both of the Players!",game.teams[0].getPlayers()[0]);
    }*/

    @GetMapping("/nextMove")
    public void nextMove() throws IOException {
        game.start();
    }

    @GetMapping("/kafka")
    public void sendMessage(@RequestParam String msg){
        kafkaTemplate.send("mytopic",msg);

    }

}
