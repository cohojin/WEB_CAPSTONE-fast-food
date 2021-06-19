package FastFoodShop.FastFood.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // order 저장
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();


    //
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id" )
    private Delivery delivery;


    //order_date 캐멀케이스를 언더바 형식으로 변형됨
    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING) // 무조건 String
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]


    // =======연관관계 메서드========

    public void setMember(Member member){
        this.member = member;
        member.getOrder().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);

    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //===생성메서드 == ///

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems){

        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for(OrderItem orderItem : orderItems){ // 강제로 for 문에 삽입하여 추가
            order.addOrderItem(orderItem);
        }
        // 주문상태
        order.setStatus(OrderStatus.ORDER);
        // 주문시간
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    // ===== 비즈니스 로직========///

    // 주문취소

    public void cancel(){
        if(delivery.getStatus() == DeliveryStatus.COMP){
            throw new IllegalStateException("이미 배송이 완료된 상품은 취소하실수 없습니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for(OrderItem orderItem : this.orderItems){
            orderItem.cancel();
        }
    }


    //조회 로직
    /**
     * 전체 주문 가격 조회
     */
    public int getTotalPrice () {
        int totalPrice = 0;
        for (OrderItem orderItem : this.orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
