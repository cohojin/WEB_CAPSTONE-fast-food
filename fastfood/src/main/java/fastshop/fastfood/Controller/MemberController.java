package fastshop.fastfood.Controller;

import fastshop.fastfood.domain.Member;
import fastshop.fastfood.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/memberJoin")
    public String createForm(){

        return "Pages/Member/member";
    }
    @PostMapping("/memberJoin")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = "+member.getName());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/memberList")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
