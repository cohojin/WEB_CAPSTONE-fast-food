package fastshop.fastfood.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/Login")
    public String home(){
        return "Pages/Login/Login";
    }


}
