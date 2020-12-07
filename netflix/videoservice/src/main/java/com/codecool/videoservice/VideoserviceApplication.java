package com.codecool.videoservice;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
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
			Video video1 = Video.builder()
					.title("Shrek VS Thanos DESPACITO battle reupload")
					.url("https://www.youtube.com/watch?v=fBDsTVlu4Gw")
					.build();
			videoRepository.save(video1);
			Video video2 = Video.builder()
					.title("Deep Purple - Highway Star")
					.url("https://www.youtube.com/watch?v=Wr9ie2J2690")
					.build();
			videoRepository.save(video2);
			Video video3 = Video.builder()
					.title("il vento d'oro")
					.url("https://www.youtube.com/watch?v=U0TXIXTzJEY")
					.build();
			videoRepository.save(video3);
		};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
//				.paths(PathSelectors.ant("/videos"))
				.build();
	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}