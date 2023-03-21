package ie.umbrella.bike.club;

import ie.umbrella.bike.club.repository.MemberRepository;
import ie.umbrella.bike.club.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(MemberRepository memberRepository,
										 ProfileRepository profileRepository) {
		return args -> {
		};
	}

}
