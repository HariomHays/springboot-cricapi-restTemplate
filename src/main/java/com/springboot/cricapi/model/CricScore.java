package com.springboot.cricapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CricScore {

    @JsonProperty("Team-1")
    private String team1;

    @JsonProperty("Team-2")
    private String team2;

    @JsonProperty("Winning team’s score")
    private String winningScore;

    @JsonProperty("Round rotation")
    private String roundRotation ;

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

    public String getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(String winningScore) {
        this.winningScore = winningScore;
    }

    public String getRoundRotation() {
        return roundRotation;
    }

    public void setRoundRotation(String roundRotation) {
        this.roundRotation = roundRotation;
    }
}
