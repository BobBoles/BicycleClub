package ie.umbrella.bike.club.controller;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bicycleclub")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public Member create(@RequestBody Member member){
        return memberService.createNewMember(member);
    }

    @PostMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member member){
        Optional<Member> retrieved = memberService.findMemberById(id);
        if(retrieved.isEmpty())
        {
            throw new RuntimeException("Member Not Found");
        }
        return memberService.update(member);
    }

    @GetMapping("/{id}")
    public Optional<Member> findMember(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteMember(@PathVariable Long id){
        Optional <Member> optionalMember = memberService.findMemberById(id);
        if (optionalMember.isPresent()) {
            memberService.deleteMember(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
