package FastFoodShop.FastFood.service;

import FastFoodShop.FastFood.domain.Member;
import FastFoodShop.FastFood.encode.EncryptHandler;
import FastFoodShop.FastFood.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Autowired
    private EncryptHandler encryptHandler;


    //회원가입
    @Transactional // 이것만 readOnly = false      나머지 true
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName()); // check overlap name?
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }



    @Transactional
    public void update(Long id, String name) {

        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

    public Member login(Member member) {

        Member findMember = memberRepository.findOneByUserid(member.getUserid());

        return findMember;
    }

//    @Override
//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        try {
//            return (UserDetails) memberRepository.findByUserid(userid);
//        } catch (Exception e) {
//            return (UserDetails) new UsernameNotFoundException("Unknown user");
//        }
//
//    }
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


    User account = (User) memberRepository.findByName(username);

    if( account == null ) {
        throw new UsernameNotFoundException(username);
    }

    return account;
}

}
