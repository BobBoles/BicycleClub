package ie.umbrella.bike.club.controller;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeLeafController {


    @Autowired
    MemberService memberService;

    public ThymeLeafController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMembers(Model model){
        model.addAttribute("members", this.memberService.getAll());
        return "members";
    }

    @GetMapping("/members/new")
    public String createMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "addMember";
    }

    @PostMapping("/members")
    public String newMember(@ModelAttribute("member") Member member){
        memberService.createNewMember(member);
        return "redirect:/members";
    }

    @GetMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        Member toBeDeleted = memberService.findMemberById(id);
        memberService.deleteMember(toBeDeleted.getId());
        return "redirect:/members";
    }

    @GetMapping("/members/edit/{id}")
    public String retrieveMemberForm(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.findMemberById(id));
        return "editmember";
    }

    @PostMapping("/members/{id}")
    public String updateMember(@PathVariable Long id,
                                @ModelAttribute("member") Member member,
                                Model model){
        //get Student from database by id
        Member existingMember = memberService.findMemberById(id);
        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        existingMember.setEmail(member.getEmail());
        memberService.update(existingMember);
        return "redirect:/members";
    }
}
