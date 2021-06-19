package FastFoodShop.FastFood.domain.Item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Marine extends Item{

    private String MName;
    private String MNum;

}
