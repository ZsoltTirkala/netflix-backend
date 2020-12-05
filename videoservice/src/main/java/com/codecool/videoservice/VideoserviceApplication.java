package com.codecool.videoservice;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class VideoserviceApplication {

	@Autowired
	VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoserviceApplication.class, args);
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init() {
		return args -> {
			Video video = Video.builder()
					.title("Hit the road Jack!")
					.url("https://www.youtube.com/watch?v=Q8Tiz6INF7I")
					.build();
			videoRepository.save(video);
		};
	}

}
