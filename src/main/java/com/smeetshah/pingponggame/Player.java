package com.smeetshah.pingponggame;

public class Player {

    enum SkillLevel{
        ROOKIE,
        AMATEUR,
        PROFESSIONAL
    }

    public String name;
    public SkillLevel skillLevel;

    public Player(String name, SkillLevel skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void upgradeSkillLevel(SkillLevel skillLevel){
        this.skillLevel = skillLevel;
    }

}
