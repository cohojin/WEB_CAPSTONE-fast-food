package fastshop.fastfood.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BestController {

    @GetMapping("/BestPage")
    public String BestPage(){
        return "html/Best";
    }
}
