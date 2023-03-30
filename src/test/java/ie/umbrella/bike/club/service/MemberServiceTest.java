package ie.umbrella.bike.club.service;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MemberServiceTest {

    @MockBean
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    private Long expectedId = 100L;

    @BeforeEach
    void setUp(){
    }

    @Test
    public void findMemberByIdTest() {
        Member mockMember = new Member("email@email.com", "firstName", "lastName");
        when(memberRepository.findById(expectedId)).thenReturn(Optional.of(mockMember));

        Member existing = memberService.findMemberById(expectedId);
        assertEquals("email@email.com", existing.getEmail());
    }


}