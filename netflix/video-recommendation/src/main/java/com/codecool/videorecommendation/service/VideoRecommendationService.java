package com.codecool.videorecommendation.service;

import com.codecool.videorecommendation.entity.VideoRecommendation;
import com.codecool.videorecommendation.repository.VideoRecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VideoRecommendationService {

    @Autowired
    VideoRecommendationRepository videoRecommendationRepository;

    public List<VideoRecommendation> getAllVideo() {
        return videoRecommendationRepository.findAll();
    }
}
