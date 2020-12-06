package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Videoservice {

    @Autowired
    VideoRepository videoRepository;

    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }
}
