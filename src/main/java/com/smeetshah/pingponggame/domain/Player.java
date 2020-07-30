package com.smeetshah.pingponggame.domain;

import com.smeetshah.pingponggame.PingPongGameController;
import org.apache.commons.io.FileUtils;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Player {

    public enum SkillLevel{
        ROOKIE,
        AMATEUR,
        PROFESSIONAL
    }

    private String name;
    private SkillLevel skillLevel;

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

    public void stroke(KafkaTemplate<String,String> kafkaTemplate, String topic, String msg) {
        kafkaTemplate.send(topic,msg);
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
