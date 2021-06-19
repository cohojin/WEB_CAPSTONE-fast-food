package FastFoodShop.FastFood.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/CustomerSupport")
    public String CustomerSupport(){
        return "Pages/html/CustomerSupport";
    }
    @GetMapping("/MyPage")
    public String MyPage(){
        return "Pages/html/MyPage";
    }

    @GetMapping("/Pay")
    public String PayPage(){
        return "Pages/html/Pay";
    }

    @GetMapping("/Best")
    public String BestPage(){
        return "Pages/html/Best";
    }

    @GetMapping("/Basket")
    public String BasketPage(){
        return "Pages/html/Basket copy";
    }
    @GetMapping("/Marine")
    public String MarinePage(){
        return "Pages/html/Marine";
    }

    @GetMapping("/LiveStock")
    public String LiveStockPage(){
        return "Pages/html/LiveStock";
    }

    @GetMapping("/MonthMoney")
    public String MonthMoneyPage(){
        return "Pages/html/MonthMoney";
    }

    @GetMapping("/MyPageCoupon")
    public String MyPageCouponPage(){
        return "Pages/html/MyPageCoupon";
    }

    @GetMapping("/MyPageDelivery")
    public String MyPageDeliveryPage(){
        return "Pages/html/MyPageDelivery";
    }

    @GetMapping("/MyPageModify")
    public String MyPageModifyPage(){
        return "Pages/html/MyPageModify";
    }

    @GetMapping("/MyPageOrder")
    public String MyPageOrderPage(){
        return "Pages/html/MyPageOrder";
    }

    @GetMapping("/NewProductPage")
    public String NewProductPagePage(){
        return "Pages/html/NewProductPage";
    }

    @GetMapping("/ProductPage")
    public String ProductPagePage(){
        return "Pages/html/ProductPage";
    }

    @GetMapping("/Welcome")
    public String WelcomePage(){
        return "Pages/html/Welcome";
    }


    @GetMapping("/members/MemberSuccess")
    public String MemberSuccess(){
        return "Pages/html/MemberSuc";
    }









}
