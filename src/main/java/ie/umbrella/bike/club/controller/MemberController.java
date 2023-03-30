package ie.umbrella.bike.club.controller;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/bicycleclub")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAll();
    }

    @PostMapping("/")
    public Member create(@RequestBody Member member){
        return memberService.createNewMember(member);
    }

    @PostMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member member){
        return memberService.findMemberById(id);
    }

    @GetMapping("/{id}")
    public Member findMember(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Member> deleteMember(@PathVariable Long id){
        return memberService.deleteMember(id);
    }
}
