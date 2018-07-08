package com.springboot.cricapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCricScore {

    @JsonProperty("team-1")
    private String team1;

    @JsonProperty("team-2")
    private String team2;

    @JsonProperty("score")
    private String score;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
