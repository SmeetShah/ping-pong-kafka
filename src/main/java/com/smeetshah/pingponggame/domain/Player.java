package com.smeetshah.pingponggame.domain;

import org.apache.commons.io.FileUtils;
import org.springframework.kafka.core.KafkaTemplate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

public class Player {

    public enum SkillLevel {
        ROOKIE,
        AMATEUR,
        PROFESSIONAL
    }

    private String name;
    private SkillLevel skillLevel;

    public Player(String name, SkillLevel skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return this.name;
    }

    public SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

    public void upgradeSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void stroke(KafkaTemplate<String, String> kafkaTemplate, String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }

    public void txtFileLogger() throws IOException {
        FileWriter moveLogger = new FileWriter("PingPong.txt", true);
        BufferedWriter loadMoveIntoBuffer = new BufferedWriter(moveLogger);
        String endMsg = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());

        if (endMsg.endsWith("Ping" + System.lineSeparator())) {
            loadMoveIntoBuffer.append("Pong" + System.lineSeparator());
        } else if (endMsg.endsWith("Pong" + System.lineSeparator()) || endMsg.isEmpty()) {
            loadMoveIntoBuffer.append("Ping" + System.lineSeparator());
        }

        loadMoveIntoBuffer.flush();
        loadMoveIntoBuffer.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                skillLevel == player.skillLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skillLevel);
    }
}
