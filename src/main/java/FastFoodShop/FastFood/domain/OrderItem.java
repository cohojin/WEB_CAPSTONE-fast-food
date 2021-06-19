package FastFoodShop.FastFood.domain;

import FastFoodShop.FastFood.domain.Item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;


    private int orderPrice; // 가격
    private int count; // 수량

    //=== 생성메서드 == //

    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);// 아이템 셋팅
        orderItem.setOrderPrice(orderPrice); // 가격 셋팅
        orderItem.setCount(count);// 제고 셋팅

        item.removeStock(count); // 재고 없앰
        return orderItem;
    }

    //======비즈니스 로직========//
    /// 취소하면 재고 다시 원래되로 됨
    public void cancel(){
        getItem().addStock(count);
    }
    // ===== 조회 로직=====////
    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }
}
