package FastFoodShop.FastFood.Controller;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;

    @NotEmpty(message = "도시를 입력하세요")
    private String city;

    @NotEmpty(message = "상세주소를 입력하세요")
    private String street;

    @NotEmpty(message = "우편번호를 입력하세요")
    private String zipcode;

    @NotEmpty(message = "아이디를 입력하세요")
    private String userid;

    @NotEmpty(message = "비밀번호를 입력하세요")
    private String userpw;


    @NotEmpty(message = "전화번호를 입력하세요")
    private String tel;


}
