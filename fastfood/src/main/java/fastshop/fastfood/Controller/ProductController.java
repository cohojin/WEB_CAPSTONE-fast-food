package fastshop.fastfood.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ProductController {

    @GetMapping("/ProductPage")
    public String product(){
        return "Pages/ProductPage/reProductPage";
    }
}
