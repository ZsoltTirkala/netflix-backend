package com.codecool.videoservice.service;

import com.codecool.videoservice.model.VideoRecommendationModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class VideoRecommendationCaller {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${video-recommendation.url}")
    private String baseUrl;

    public VideoRecommendationModel videoWithRecommendation() {
        log.info("== Video with recommendation ==");
        VideoRecommendationModel body = restTemplate.getForEntity(baseUrl + "/recommendation", VideoRecommendationModel.class).getBody();
        return body;
    }
}
