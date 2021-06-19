package FastFoodShop.FastFood.Controller;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty(message = "아이디를 입력하세요")
    private String userid;

    @NotEmpty(message = "비밀번호를 입력하세요")
    private String userpw;
}
