package FastFoodShop.FastFood.service;


import FastFoodShop.FastFood.domain.Delivery;
import FastFoodShop.FastFood.domain.Item.Item;
import FastFoodShop.FastFood.domain.Member;
import FastFoodShop.FastFood.domain.Order;
import FastFoodShop.FastFood.domain.OrderItem;
import FastFoodShop.FastFood.repository.ItemRepository;
import FastFoodShop.FastFood.repository.MemberRepository;
import FastFoodShop.FastFood.repository.OrderRepository;
import FastFoodShop.FastFood.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        //엔티티조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문저장
        orderRepository.save(order);

        return order.getId();
    }
    //취소
    //주문취소

    @Transactional
    public void cancelOrder(Long orderId){
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문취소
        order.cancel();

    }

    //검색
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByString(orderSearch);
    }
}
