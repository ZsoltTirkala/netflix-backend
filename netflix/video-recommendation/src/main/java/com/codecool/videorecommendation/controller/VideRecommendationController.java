package com.codecool.videorecommendation.controller;

import com.codecool.videorecommendation.VideoRecommendationApplication;
import com.codecool.videorecommendation.entity.VideoRecommendation;
import com.codecool.videorecommendation.service.VideoRecommendationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class VideRecommendationController {

    VideoRecommendationService videoRecommendationService;

    @Autowired
    public VideRecommendationController(VideoRecommendationService videoRecommendationService) {
        this.videoRecommendationService = videoRecommendationService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value = "Send all the videos")
    @GetMapping("/recommendation")
    public List<VideoRecommendation> getAllVideo() {
        return videoRecommendationService.getAllVideo();
    }
}
