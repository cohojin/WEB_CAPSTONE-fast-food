package fastshop.fastfood.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonthMoneyController {

    @GetMapping("/Money")
    public String MonthMoney(){

        return "html/MonthMoney";
    }


}
