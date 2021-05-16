package fastshop.fastfood.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product_periods {

    @Id
    @GeneratedValue
    private int periods_id;
    private String start_date;
    private String end_date;

}
