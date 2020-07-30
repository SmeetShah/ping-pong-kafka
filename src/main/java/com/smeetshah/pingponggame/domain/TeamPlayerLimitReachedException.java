package com.smeetshah.pingponggame.domain;

public class TeamPlayerLimitReachedException extends RuntimeException{
    public TeamPlayerLimitReachedException() {
        super("Team Player Limit Reached");
    }
}
