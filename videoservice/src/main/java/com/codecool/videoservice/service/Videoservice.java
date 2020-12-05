package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Videoservice {

    @Autowired
    VideoRepository videoRepository;

    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }
}
