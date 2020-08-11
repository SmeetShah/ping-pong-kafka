package com.smeetshah.pingponggame;

import com.smeetshah.pingponggame.api.Request;
import com.smeetshah.pingponggame.domain.PingPongGame;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PingPongGameController {

    private ApiToDomainConverter apiToDomainConverter;
    private PingPongGame game;
    private static final String TOPIC = "mytopic";

    public PingPongGameController(ApiToDomainConverter apiToDomainConverter) {
        this.apiToDomainConverter = apiToDomainConverter;
    }

    @PostMapping(value = "/startGame",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void startGame(@RequestBody Request request) throws IOException {
        game = new PingPongGame(apiToDomainConverter.fromApiToDomain(request.getGameConfig(),TOPIC),
                                apiToDomainConverter.teamsFromApiToDomain(request.getTeams(),request.getGameConfig().getPlayerLimitEachTeam()));
    }

    @GetMapping("/nextMove")
    public void nextMove() throws IOException, InterruptedException {
        game.start();
    }

    @GetMapping("/kafka")
    public void sendMessage(@RequestParam String msg){
       // kafkaTemplate.send("mytopic",msg);

    }

}
