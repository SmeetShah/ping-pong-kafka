package com.smeetshah.pingponggame;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Player {

    enum SkillLevel{
        ROOKIE,
        AMATEUR,
        PROFESSIONAL
    }

    private String name;
    private SkillLevel skillLevel;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public Player(String name, SkillLevel skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return this.name;
    }

    public SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

    public void upgradeSkillLevel(SkillLevel skillLevel){
        this.skillLevel = skillLevel;
    }

    public void stroke(String message) {

        kafkaTemplate.send("game_pingpong", message);

    }


    public void txtFileLogger() throws IOException{
        FileWriter moveLogger = new FileWriter("PingPong.txt",true);
        BufferedWriter loadMoveIntoBuffer = new BufferedWriter(moveLogger);

        String endMsg = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());

        if(endMsg.endsWith("Ping"+System.lineSeparator())){
            loadMoveIntoBuffer.append("Pong"+System.lineSeparator());
        }else if(endMsg.endsWith("Pong"+System.lineSeparator()) || endMsg.isEmpty()){
            loadMoveIntoBuffer.append("Ping"+System.lineSeparator());
        }

        loadMoveIntoBuffer.flush();
        loadMoveIntoBuffer.close();
    }

}
