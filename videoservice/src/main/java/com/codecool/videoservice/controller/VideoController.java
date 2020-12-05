package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.service.Videoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    Videoservice videoService;

    @Autowired
    public VideoController(Videoservice videoService) {
        this.videoService = videoService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/videos")
    public List<Video> getAllVideo() {
        return videoService.getAllVideo();
    }
}
