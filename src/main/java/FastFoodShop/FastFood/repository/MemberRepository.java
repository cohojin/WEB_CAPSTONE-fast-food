package FastFoodShop.FastFood.repository;


import FastFoodShop.FastFood.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {



    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Member> findByUserid(String userid){
        return em.createQuery("select m from Member m where m.userid =:userid", Member.class)
                .setParameter("userid",userid)
                .getResultList();
    }

    public Member findOneByName(String name) { // find member by name

        try {

            return em.createQuery("select m from Member m where m.name = :name", Member.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch(Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public Member findOneByUserid(String userid) { // find member by name

        try {

            return em.createQuery("select m from Member m where m.userid = :userid", Member.class)
                    .setParameter("userid", userid)
                    .getSingleResult();
        } catch(Exception e) {

            e.printStackTrace();
            return null;
        }
    }


}
