package FastFoodShop.FastFood.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // 기본 생성자 아무것도 입력안하면 안됨 jpa 스팩
    protected Address(){
    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
