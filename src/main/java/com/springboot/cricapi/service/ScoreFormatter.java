package com.springboot.cricapi.service;

import com.springboot.cricapi.model.CricScore;
import com.springboot.cricapi.model.JsonCricScore;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreFormatter {

    public static CricScore format(JsonCricScore jsonCricScore) {

        CricScore cricScore = new CricScore();
        cricScore.setTeam1(jsonCricScore.getTeam1());
        cricScore.setTeam2(jsonCricScore.getTeam2());

        String[] tokens = jsonCricScore.getScore().split(" ");
        List<String> scores = Arrays.stream(tokens).filter(t -> t.matches("[\\d]+/[\\d]")).collect(Collectors.toList());

        int winningRun = 0 ;
        String winningScore = null;

        for(String score: scores) {
            int run = Integer.parseInt(score.split("/")[0]);
           if (run > winningRun) {
               winningRun = run ;
               winningScore = score ;
           } 
        }
        cricScore.setWinningScore(winningScore);

        String s = winningScore.substring(winningScore.length()-1) + winningScore.substring(0,winningScore.length()-1);
        cricScore.setRoundRotation(s);

        return cricScore;
    }
}
