package FastFoodShop.FastFood.domain.Item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class LiveStock extends Item{

    private String LName;
    private String LNum;
}
