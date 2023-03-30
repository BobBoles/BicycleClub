package ie.umbrella.bike.club.service;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.exception.ResourceNotFoundException;
import ie.umbrella.bike.club.repository.MemberRepository;
import ie.umbrella.bike.club.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public Member createNewMember(Member member) {
        return memberRepository.save(member);
    }

    public Member update(Member member){
        Member existingMember = memberRepository.findById(member.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id :" + member.getId()));
        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        existingMember.setPassword(member.getPassword());
        existingMember.setEmail(member.getEmail());
        existingMember.setBikes(member.getBikes());
        existingMember.setRaces(member.getRaces());
        return memberRepository.save(existingMember);
    }

    public Member findMemberById(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found with id :" + id));
    }

    public ResponseEntity<Member> deleteMember(Long id){
        Member existingMember = this.memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id :" + id));
        this.memberRepository.delete(existingMember);
        return ResponseEntity.ok().build();
    }
}
