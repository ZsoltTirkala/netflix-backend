package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.VideoRecommendationModel;
import com.codecool.videoservice.service.Videoservice;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VideoController {

    Videoservice videoService;

    @Autowired
    public VideoController(Videoservice videoService) {
        this.videoService = videoService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value = "Send all the videos")
    @GetMapping("/videos")
    public List<Video> getAllVideo() {
        List<Video> allVideo = videoService.getAllVideo();
        return allVideo;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value = "Send all the videos with recommendation")
    @GetMapping("/video/{id}")
    public Video getVideoWithRecommendations(@PathVariable Long id) {
        return null;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value = "Update video and recommendations")
    @PostMapping("/video-update")
    public void updateVideoAndRecommendation(@RequestParam(value = "video-title") String title, @RequestParam(value = "video-url") String url, @RequestParam(value = "comment") String comment) {

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value = "Update video and recommendations")
    @GetMapping("/videowithrecommendation")
    public String getVideoRecommendationModel() {
        log.info("asdasda");
        String videoRecommendation = videoService.getVideoRecommendation();
        log.info("VIDEOSERVICE !!!!!!-----------------------------------------------------------------");
        log.info(videoRecommendation.toString());
        return videoRecommendation;
    }
}