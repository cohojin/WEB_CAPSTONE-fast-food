package fastshop.fastfood.Repository;


import fastshop.fastfood.domain.Member;
import fastshop.fastfood.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(Product product) {

        em.persist(product);

        return product.getProduct_id();
    }
}
