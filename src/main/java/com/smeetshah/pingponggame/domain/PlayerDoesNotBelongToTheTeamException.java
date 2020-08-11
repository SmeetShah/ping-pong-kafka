package com.smeetshah.pingponggame.domain;

public class PlayerDoesNotBelongToTheTeamException extends RuntimeException {
    public PlayerDoesNotBelongToTheTeamException() {
        super("Player Does Not Belong To The Team");
    }
}
