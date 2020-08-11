package com.smeetshah.pingponggame.domain;

import com.smeetshah.pingponggame.ApiToDomainConverter;
import com.smeetshah.pingponggame.api.GameConfig;
import com.smeetshah.pingponggame.api.Player;
import com.smeetshah.pingponggame.api.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ApiToDomainConverterTest {

    private static final String TOPIC = "mytopic";
    private static final GameConfig API_GAME_CONFIG = new GameConfig(3, 9, 1);
    private ApiToDomainConverter apiToDomainConverter;
    private KafkaTemplate<String, String> kafkaTemplate = mock(KafkaTemplate.class);

    @BeforeEach
    void setUp() {
        apiToDomainConverter = new ApiToDomainConverter(kafkaTemplate);
    }

    @Test
    public void shouldConvertGameConfig() {
        com.smeetshah.pingponggame.domain.GameConfig expectedConfig = new com.smeetshah.pingponggame.domain.GameConfig(3, 9, 1, kafkaTemplate, TOPIC);
        com.smeetshah.pingponggame.domain.GameConfig actualConfig = apiToDomainConverter.fromApiToDomain(API_GAME_CONFIG, TOPIC);

        Assertions.assertEquals(expectedConfig, actualConfig);
    }

    @Test
    public void shouldConvertTeams() {
        List<Team> apiTeams = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Smeet", "ROOKIE"));
        apiTeams.add(new Team("team1", players));

        List<com.smeetshah.pingponggame.domain.Team> expectedTeams = new ArrayList<>();
        expectedTeams.add(new com.smeetshah.pingponggame.domain.Team("team1", 1));
        expectedTeams.get(0).addPlayer(new com.smeetshah.pingponggame.domain.Player("Smeet", com.smeetshah.pingponggame.domain.Player.SkillLevel.ROOKIE));

        List<com.smeetshah.pingponggame.domain.Team> actualTeams = apiToDomainConverter.teamsFromApiToDomain(apiTeams, 1);

        Assertions.assertEquals(expectedTeams, actualTeams);
    }

}
