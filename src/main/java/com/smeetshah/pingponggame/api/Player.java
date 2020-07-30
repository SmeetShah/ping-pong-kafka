package com.smeetshah.pingponggame.api;

public class Player {
    private String name;
    private String skillLevel;

    public Player(String name, String skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                '}';
    }
}
