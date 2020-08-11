package com.smeetshah.pingponggame;

import com.smeetshah.pingponggame.domain.GameConfig;
import com.smeetshah.pingponggame.domain.Player;
import com.smeetshah.pingponggame.domain.Team;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiToDomainConverter {

    private KafkaTemplate<String, String> kafkaTemplate;

    public ApiToDomainConverter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public GameConfig fromApiToDomain(com.smeetshah.pingponggame.api.GameConfig gameConfig, String kafkaTopic) {
        GameConfig tempGameConfig = new GameConfig(gameConfig.getRoundsPerGame(), gameConfig.getMaxShotsPerRound(),
                                                    gameConfig.getPlayerLimitEachTeam(),kafkaTemplate, kafkaTopic);

        return tempGameConfig;
    }

    public List<Team> teamsFromApiToDomain(List<com.smeetshah.pingponggame.api.Team> teams, int playerLimitEachTeam) {
        List<Team> finalTeams = new ArrayList<>();

        for (com.smeetshah.pingponggame.api.Team team : teams) {
            Team newTeam = new Team(team.getName(),playerLimitEachTeam);
            for (com.smeetshah.pingponggame.api.Player player : team.getPlayers()) {
                Player newPlayer = new Player(player.getName(), Player.SkillLevel.valueOf(player.getSkillLevel()));
                newTeam.addPlayer(newPlayer);
            }
            finalTeams.add(newTeam);
        }
        return finalTeams;
    }

}
