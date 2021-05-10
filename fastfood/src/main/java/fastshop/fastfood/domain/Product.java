package fastshop.fastfood.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue
    private Long product_id; // 상품번호
    private String p_name;
    private int price;
    private int name_ID;




}


