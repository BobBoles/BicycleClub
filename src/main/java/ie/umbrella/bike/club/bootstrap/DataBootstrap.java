package ie.umbrella.bike.club.bootstrap;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.entity.Profile;
import ie.umbrella.bike.club.repository.MemberRepository;
import ie.umbrella.bike.club.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Component
public class DataBootstrap implements CommandLineRunner {

    private MemberRepository memberRepository;
    private ProfileRepository profileRepository;

    @Autowired
    public DataBootstrap(ProfileRepository profileRepository, MemberRepository memberRepository) {
        this.profileRepository = profileRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Member member = Member.builder()
                .firstName("Joe")
                .lastName("Bloggs")
                .email("joe.bloggs@example.com")
                .password("1234abcd")
                .build();

        Profile profile = Profile.builder()
                .address("Roscommon")
                .bio("Loves cycling")
                .dob(LocalDate.parse("1970-01-08"))
                .build();

        member.setProfile(profile);
        profile.setMember(member);
        memberRepository.save(member);
        profileRepository.save(profile);
    }
}