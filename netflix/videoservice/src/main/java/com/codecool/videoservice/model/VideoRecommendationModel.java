package com.codecool.videoservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoRecommendationModel {
    private String recommendation;
    private int rating;
    private int videoId;

}
