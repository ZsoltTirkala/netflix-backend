package com.codecool.videorecommendation.repository;

import com.codecool.videorecommendation.entity.VideoRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRecommendationRepository extends JpaRepository<VideoRecommendation, Long> {
}
