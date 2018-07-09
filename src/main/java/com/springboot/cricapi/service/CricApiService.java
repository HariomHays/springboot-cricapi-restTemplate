package com.springboot.cricapi.service;

import com.springboot.cricapi.exceptionhandler.ServerException;
import com.springboot.cricapi.model.JsonCricScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CricApiService {

    @Autowired
    private RestTemplate restTemplate;

    private final String ROOT_URI = "http://cricapi.com/api/cricketScore?apikey=WmPJrX2s3KMyZVPFwlm1vxXLXKw1";

    public JsonCricScore getCricScore(Integer matchId) {
        try {
            ResponseEntity<JsonCricScore> response = restTemplate.getForEntity(ROOT_URI + "&unique_id=" + matchId, JsonCricScore.class);

            if (HttpStatus.OK.equals(response.getStatusCode())) {
                return response.getBody();
            } else {
                throw new ServerException(response.getStatusCode());
            }
        } catch (Exception e) {
            throw new ServerException(e);
        }
    }

}
