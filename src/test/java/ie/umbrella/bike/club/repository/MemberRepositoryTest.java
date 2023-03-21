package ie.umbrella.bike.club.repository;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.entity.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ProfileRepository profileRepository;
    Member member;
    Profile profile;

    Long memberId, profileId;
    @BeforeEach
    public void setUp(){
        member = Member.builder()
                .firstName("Bob")
                .lastName("Boles")
                .email("bolesb@gmail.com")
                .password("1234abcd")
                .build();

        profile = Profile.builder()
                .address("Roscommon")
                .bio("Some bio text")
                .dob(LocalDate.parse("1970-01-08"))
                .build();

        member.setProfile(profile);
        profile.setMember(member);
        Member savedMember = memberRepository.save(member);
        Profile savedProfile = profileRepository.save(profile);
        memberId=savedMember.getId();
        profileId=savedProfile.getId();
    }


    @Test
    public void testGetPersonWithAddress(){
        Member member = memberRepository.findById(memberId).orElse(null);
        assertNotNull(member.getProfile());
        assertEquals("Roscommon", profile.getAddress());
    }

    @Test
    public void testGetProfileWithMember(){
        Profile profile = profileRepository.findById(profileId).orElse(null);
        assertNotNull(profile.getMember());
        assertEquals("Bob", profile.getMember().getFirstName());
    }

    @Test
    public void testDeleteCascade() {
        memberRepository.delete(member);
        Profile profile = profileRepository.findById(profileId).orElse(null);
        assertNull(profile);
    }
}
