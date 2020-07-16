package com.example.demo;

import ch.qos.logback.core.FileAppender;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

public class FileMessageAppenderTest {

    private FileReader file;
    private FileMessageAppender fileMsgAppenderTest = new FileMessageAppender();
    private BufferedReader msgHolder;


    @Test
    public void test10WritesOfPingPong() throws IOException {

        for(int iteration = 0; iteration<10; iteration++) {
            fileMsgAppenderTest.addMessage("Ping");
            fileMsgAppenderTest.addMessage("Pong");
        }

        file = new FileReader("PingPong.txt");
        msgHolder = new BufferedReader(file);

        String line;
        int pingCounter = 0, pongCounter = 0, writeCounter = 0;

        while((line = msgHolder.readLine()) != null){
            if(writeCounter % 2 == 0){
                pingCounter = line.equals("Ping") ? pingCounter++ : pingCounter;
            }else{
                pongCounter = line.equals("Pong") ? pongCounter++ : pongCounter;
            }
            writeCounter++;
        }
        msgHolder.close();
        file.close();

        Assertions.assertEquals(10,pingCounter);
        Assertions.assertEquals(10,pongCounter);
    }

    @Test
    public void shouldAddMessageToTextFile() throws IOException {
        fileMsgAppenderTest.addMessage("Smeet");

        String content = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());

        Assertions.assertEquals("Smeet"+System.lineSeparator(),content);

    }
}
