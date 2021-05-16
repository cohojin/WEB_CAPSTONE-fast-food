package fastshop.fastfood.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {

    @GetMapping("/PayPage")
    public String PayPage(){
        return "html/Pay";
    }
}
