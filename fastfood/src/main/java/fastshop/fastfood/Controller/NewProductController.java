package fastshop.fastfood.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewProductController {

    @GetMapping("/newProduct")
    public String newProduct(){

        return "html/NewProductPage";
    }
}
