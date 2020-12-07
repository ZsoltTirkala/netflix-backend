package com.codecool.videorecommendation;

import com.codecool.videorecommendation.entity.VideoRecommendation;
import com.codecool.videorecommendation.repository.VideoRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoRecommendationApplication {

@Autowired
	VideoRecommendationRepository videoRecommendationRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoRecommendationApplication.class, args);
	}


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init() {
		return args -> {
			VideoRecommendation videoRecommendation = VideoRecommendation.builder()
					.recommendation("ASDASDSAD")
					.rating(2)
					.videoId(1)
					.build();
			videoRecommendationRepository.save(videoRecommendation);
		};
	}
}