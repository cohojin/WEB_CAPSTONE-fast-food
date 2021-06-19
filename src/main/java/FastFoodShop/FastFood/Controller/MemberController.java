package FastFoodShop.FastFood.Controller;


import FastFoodShop.FastFood.jwt.JwtTokenProvider;
import FastFoodShop.FastFood.domain.Address;
import FastFoodShop.FastFood.domain.Member;
import FastFoodShop.FastFood.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/Member";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){

        if(result.hasErrors()){
            return "members/Member";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);
        member.setUserid(form.getUserid());
        member.setUserpw(form.getUserpw());
        member.setTel(form.getTel());

        memberService.join(member);
        return "redirect:/members/MemberSuccess";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

    @Data
    static class CreateMemberResponse {

        private Long id;

        public CreateMemberResponse(Long id) {

            this.id = id;
        }
    }



    @Data
    @AllArgsConstructor
    static class Result<T> {

        private T data;
    }

    @Data
    @AllArgsConstructor
    public static class MemberDto {

        private String userid;
        private String userpw;
    }

    @Data
    static class CheckMemberResponse {

        private String userid;
        private String userpw;

        private boolean loginFlag;

        public CheckMemberResponse() {

            this.loginFlag = false;
        }

        public CheckMemberResponse(String userid, String userpw, boolean loginFlag) {

            this.userid = userid;
            this.userpw = userpw;
            this.loginFlag = loginFlag;
        }
    }


    CreateMemberResponse createMemberResponse;

    @GetMapping("/members/login")
    public String login()
    {
        return "members/Login";
    }


    @PostMapping("/members/login")
    public String signIn(@RequestBody Member member) {

        Member findmember = memberService.login(member);
        createMemberResponse = new CreateMemberResponse(findmember.getId());

        if(!passwordEncoder.matches(member.getPassword(), findmember.getPassword())) {
            throw new IllegalArgumentException("unknown user");
        }

        return "redirect:/" + jwtTokenProvider.createToken(findmember.getUsername());
    }

    @GetMapping("/members/loginSuc")
    public  String loginSuc(){
        return "Pages/html/LoginSuccess";
    }





}
