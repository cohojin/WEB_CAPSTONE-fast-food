package FastFoodShop.FastFood.service;


import FastFoodShop.FastFood.domain.Item.Marine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {
    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception{

        Marine book = em.find(Marine.class, 1L);

        book.setName("aaaaa");
        //변경감지 === dirty checking

    }

}
