package ie.umbrella.bike.club.service;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.entity.Profile;
import ie.umbrella.bike.club.repository.MemberRepository;
import ie.umbrella.bike.club.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member createNewMember(Member member){
        return memberRepository.save(member);
    }

    public Member update(Member member){
        return memberRepository.save(member);
    }

    public Optional<Member> findMemberById(Long id){
        return memberRepository.findById(id);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
