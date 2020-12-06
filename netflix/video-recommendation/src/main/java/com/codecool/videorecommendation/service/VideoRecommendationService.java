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

    public void addNewRecommendation(int id, String recommendation, int rating) {
        VideoRecommendation videoRecommendation = VideoRecommendation
                .builder()
                .recommendation(recommendation)
                .rating(rating)
                .videoId(id)
                .build();

        videoRecommendationRepository.save(videoRecommendation);
    }

    public List<VideoRecommendation> getAllRecommendation(int videoId) {
       return videoRecommendationRepository.getAllRecommendation(videoId);
    }

//    public void editRecommendation(int videoId, String recommendation, int rating) {
//        videoRecommendationRepository.editRecommendation(recommendation,rating,videoId,);
//    }
}
