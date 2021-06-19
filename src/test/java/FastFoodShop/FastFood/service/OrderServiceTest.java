package FastFoodShop.FastFood.service;

import FastFoodShop.FastFood.domain.Address;
import FastFoodShop.FastFood.domain.Item.Marine;
import FastFoodShop.FastFood.domain.Item.Item;
import FastFoodShop.FastFood.domain.Member;
import FastFoodShop.FastFood.domain.Order;
import FastFoodShop.FastFood.domain.OrderStatus;
import FastFoodShop.FastFood.exception.NotEnoughStockException;
import FastFoodShop.FastFood.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception{
        //given
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("의정부","겅기","1111-1111"));
        em.persist(member);
        Item item = new Marine();

        Item book = new Marine();
        book.setName("ghghghghg");
        book.setPrice(555555);
        book.setStockQuantity(10);

        em.persist(book);

        //when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(),orderCount);
        //then

        Order getOrder = orderRepository.findOne(orderId);
        Assert.assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER,getOrder.getStatus());
        Assert.assertEquals("주문한 상품 종류수가 정확", 1,getOrder.getOrderItems().size());
        Assert.assertEquals("주문 가격 = 가격 * 수량", 555555*orderCount,getOrder.getTotalPrice());
        Assert.assertEquals("주문 수량만큼 재고가 줄어야 한다.", 8,book.getStockQuantity());
    }

    @Test
    public void 주문취소() throws Exception{
        //given
        //when
        //then
    }


    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception{
        //given
        //when
        //then
    }

}