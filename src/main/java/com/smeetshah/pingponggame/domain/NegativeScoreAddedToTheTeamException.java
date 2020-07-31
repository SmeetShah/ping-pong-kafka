package com.smeetshah.pingponggame.domain;

public class NegativeScoreAddedToTheTeamException extends RuntimeException{
    public NegativeScoreAddedToTheTeamException() {
        super("Negative Score Being Added To The Team");
    }
}
