package com.codecool.videorecommendation.repository;

import com.codecool.videorecommendation.entity.VideoRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface VideoRecommendationRepository extends JpaRepository<VideoRecommendation, Long> {

    @Query("SELECT v FROM VideoRecommendation v WHERE v.videoId = ?1")
    List<VideoRecommendation> getAllRecommendation(int videoId);

//    @Transactional
//    @Modifying
//    @Query("UPDATE VideoRecommendation v SET v.recommendation = ?1, v.rating =?2 WHERE ")
//    void editRecommendation(String recommendation,int rating,int videoId);
}
