package com.smeetshah.pingponggame;

import com.smeetshah.pingponggame.api.Request;
import com.smeetshah.pingponggame.domain.PingPongGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PingPongGameController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private ApiToDomainConverter apiToDomainConverter;

    private PingPongGame game;
    private static final String TOPIC = "mytopic";

    @PostMapping(value = "/startGame",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void startGame(@RequestBody Request request) throws IOException {
        game = new PingPongGame(apiToDomainConverter.gameConfigFromApiToDomain(request.getGameConfig(),kafkaTemplate, TOPIC),
                                apiToDomainConverter.teamsFromApiToDomain(request.getTeams()));
    }

    @GetMapping("/nextMove")
    public void nextMove() throws IOException, InterruptedException {
        game.start();
    }

    @GetMapping("/kafka")
    public void sendMessage(@RequestParam String msg){
        kafkaTemplate.send("mytopic",msg);

    }

}
