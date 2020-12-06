package com.codecool.videorecommendation.controller;

import com.codecool.videorecommendation.VideoRecommendationApplication;
import com.codecool.videorecommendation.entity.VideoRecommendation;
import com.codecool.videorecommendation.service.VideoRecommendationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "Get a video's recommendation")
    @GetMapping("/recommendation/{id}")
    public List<VideoRecommendation> getAllRecommendation(@PathVariable int videoId) {
        return videoRecommendationService.getAllRecommendation(videoId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value = "Add new recommendation to a video")
    @PostMapping("/recommendation/{id}")
    public void addNewRecommendation(@PathVariable int videoId,@RequestParam(value = "recommendation") String recommendation, @RequestParam(value = "rating") int rating) {
    videoRecommendationService.addNewRecommendation(videoId,recommendation,rating);
    }

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @ApiOperation(value = "Edit a recommendation")
//    @PutMapping("/recommendation")
//    public void editRecommendation(@PathVariable int videoId,@RequestParam(value = "recommendation") String recommendation, @RequestParam(value = "rating") int rating) {
//        videoRecommendationService.editRecommendation(videoId,recommendation,rating);
//    }

}
