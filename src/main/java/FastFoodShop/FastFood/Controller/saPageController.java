package FastFoodShop.FastFood.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class saPageController {

        /*
    * 1. 큰컵불닭볶음면
2. 오페라스위트 2종
3. 고래사 크림치즈볼
4. 장어
5. 육지도 생 참치회
    *
    * */


    //new Product
    @GetMapping("/loginrlaalsgh9511/item/NP1")
    public String P1P(){
        return "Pages/SaPages/ProductPage_new1";
    }
    @GetMapping("/loginrlaalsgh9511/item/NP2")
    public String P2P(){
        return "Pages/SaPages/ProductPage_new2";
    }

    @GetMapping("/loginrlaalsgh9511/item/NP3")
    public String P3P(){
        return "Pages/SaPages/ProductPage_new3";
    }
    @GetMapping("/loginrlaalsgh9511/item/NP4")
    public String P4P(){
        return "Pages/SaPages/ProductPage_new4";
    }
    @GetMapping("/loginrlaalsgh9511/item/NP5")
    public String P5P(){
        return "Pages/SaPages/ProductPage_new5";
    }

    // NewPay
    @GetMapping("/loginrlaalsgh9511/Pay/NPP1")
    public String Pa1P(){
        return "Pages/SaPages/Pay_1";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/NPP2")
    public String Pa2P(){
        return "Pages/SaPages/Pay_2";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/NPP3")
    public String Pa3P(){
        return "Pages/SaPages/Pay_3";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/NPP4")
    public String Pa4P(){
        return "Pages/SaPages/Pay_4";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/NPP5")
    public String Pa5P(){
        return "Pages/SaPages/Pay_5";
    }



    //MoneyPay
    @GetMapping("/loginrlaalsgh9511/Pay/MoneyMonthPay")
    public String MoneyPay(){
        return "Pages/SaPages/MoneyPay";
    }





    /*
    *6. 국산콩 두부
7. 또띠아 10종
8. 고무장갑
9. 한돈목살
10. 청양고추
    * */


    // best Product
    @GetMapping("/loginrlaalsgh9511/item/BP1")
    public String B1P(){
        return "Pages/SaPages/ProductPage_best6";
    }
    @GetMapping("/loginrlaalsgh9511/item/BP2")
    public String B2P(){
        return "Pages/SaPages/ProductPage_best7";
    }
    @GetMapping("/loginrlaalsgh9511/item/BP3")
    public String B3P(){
        return "Pages/SaPages/ProductPage_best8";
    }
    @GetMapping("/loginrlaalsgh9511/item/BP4")
    public String B4P(){
        return "Pages/SaPages/ProductPage_best9";
    }
    @GetMapping("/loginrlaalsgh9511/item/BP5")
    public String B5P(){
        return "Pages/SaPages/ProductPage_best10";
    }



    // best Pay
    @GetMapping("/loginrlaalsgh9511/Pay/BPP1")
    public String Ba1P(){
        return "Pages/SaPages/Pay_6";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/BPP2")
    public String Ba2P(){
        return "Pages/SaPages/Pay_7";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/BPP3")
    public String Ba3P(){
        return "Pages/SaPages/Pay_8";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/BPP4")
    public String Ba4P(){
        return "Pages/SaPages/Pay_9";
    }
    @GetMapping("/loginrlaalsgh9511/Pay/BPP5")
    public String Ba5P(){
        return "Pages/SaPages/Pay_10";
    }







    
    
    
    
}
