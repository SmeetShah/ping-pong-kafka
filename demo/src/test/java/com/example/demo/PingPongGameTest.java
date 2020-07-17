package com.example.demo;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

public class PingPongGameTest {

    private FileReader file;
    private PingPongGame game;
    private BufferedReader msgHolder;



    @Test
    public void shouldMakeFirstMove() throws IOException {
        game = new PingPongGame();
        game.nextMove();

        String content = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());

        Assertions.assertEquals("Ping"+System.lineSeparator(),content);

    }

    @Test
    public void shouldRespondToFirstMove() throws IOException {
        game = new PingPongGame();
        game.nextMove();
        game.nextMove();

        String content = FileUtils.readFileToString(new File("PingPong.txt"), Charset.defaultCharset());

        String moves[] = content.split(System.lineSeparator());

        Assertions.assertEquals("Ping",moves[0]);
        Assertions.assertEquals("Pong",moves[1]);

    }
}
