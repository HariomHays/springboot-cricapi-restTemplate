package com.springboot.cricapi.service;

import com.springboot.cricapi.model.JsonCricScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CricApiService {

    @Autowired
    RestTemplate restTemplate;

    final String ROOT_URI = "http://cricapi.com/api/cricketScore?apikey=WmPJrX2s3KMyZVPFwlm1vxXLXKw1";

    public JsonCricScore getCricScore(Integer matchId) {
        ResponseEntity<JsonCricScore> response = restTemplate.getForEntity(ROOT_URI + "&unique_id="+matchId, JsonCricScore.class);
        return response.getBody();

    }

}
