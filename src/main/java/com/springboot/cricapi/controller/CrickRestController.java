package com.springboot.cricapi.controller;

import com.springboot.cricapi.model.CricScore;
import com.springboot.cricapi.model.JsonCricScore;
import com.springboot.cricapi.service.CricApiService;
import com.springboot.cricapi.service.ScoreFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cric")
public class CrickRestController {

    //12345
    @Autowired
    private CricApiService cricApiService;

    @GetMapping("/getscore")
    public CricScore getScore(@RequestParam("matchId") Integer matchId) {
       JsonCricScore jsonCricScore = cricApiService.getCricScore(matchId);
        return ScoreFormatter.format(jsonCricScore);


    }

}
