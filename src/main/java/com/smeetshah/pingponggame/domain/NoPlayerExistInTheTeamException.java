package com.smeetshah.pingponggame.domain;

public class NoPlayerExistInTheTeamException extends RuntimeException{
    public NoPlayerExistInTheTeamException() {
        super("No Players Exist In The Team");
    }
}
