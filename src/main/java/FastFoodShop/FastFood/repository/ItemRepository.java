package FastFoodShop.FastFood.repository;


import FastFoodShop.FastFood.domain.Item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){ // 아이텝 값이 있으면 있는거 가져올거임
            em.persist(item);
        }
        else{ // 아이템 값이 없으면 신규로 등록
            em.merge(item);
        }
    }

    public Item findOne(Long id)
    {
        return em.find(Item.class, id);

    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }
}
