package fastshop.fastfood.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
    @GetMapping("/")
    public String home(){
        return "Pages/re_main/re_main";
    }
}
