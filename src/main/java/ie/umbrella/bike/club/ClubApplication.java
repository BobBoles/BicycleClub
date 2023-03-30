package ie.umbrella.bike.club;

import ie.umbrella.bike.club.entity.Bike;
import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.entity.Profile;
import ie.umbrella.bike.club.entity.Race;
import ie.umbrella.bike.club.repository.MemberRepository;
import ie.umbrella.bike.club.repository.ProfileRepository;
import ie.umbrella.bike.club.repository.RaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ClubApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(ClubApplication.class);

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	RaceRepository raceRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClubApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(MemberRepository memberRepository,
										 ProfileRepository profileRepository) {
		return args -> {
		};
	}

	@Override
	public void run(String... args) throws Exception {
		//profile
//
//		String address = "Roscommon";
//		String bio = "This is my story";
//		LocalDate dob = LocalDate.parse("1970-06-06");
//		Profile profile1 = new Profile(address, bio, dob);
//		//bikes
//		Bike bike = new Bike();
//		bike.setBrand("brand");
//		bike.setType("type");
//		bike.setModel("model");
//		Bike bike2 = new Bike();
//		bike2.setBrand("Gary Fisher");
//		bike2.setType("mountainbike");
//		bike2.setModel("Big Sur");
//		Set<Bike> bikes = new HashSet<Bike>();
//		bikes.add(bike);
//		bikes.add(bike2);
//		//races
//		Set<Race> races = new HashSet<Race>();
//		Race race1 = new Race("New Year Fifty", 50, LocalDate.parse("2023-01-01"));
//		Race race2 = new Race("February Race", 50, LocalDate.parse("2023-02-02"));
//		races.add(race1);
//		races.add(race2);
//		//member
//		String email = new String("email@emai.com");
//		String firstName = new String("firstName");
//		String lastName = new String("lastName");
//		String password = new String("qwerty1234");
//		Member member = new Member(email, firstName, lastName, password, profile1, bikes, races);
//		if(memberRepository.findByEmail(email) != null) {
//			//already exists
//			logger.info("ignoring as database already intialised");
//		}
//		else{
//			logger.info("initialising the database");
//			memberRepository.save(member);
//		}
	}
}
