package jpabook.jpashop.repository;

import jpabook.jpashop.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    @PersistenceContext
    private final EntityManager em;

    /***
     *  if문이 들어가야 하는 이유는 아이탬이 처음 등록 될 경우에는 DB에 id가 없어야 정상임
     * @param item
     */
    public void save(Item item) {
        em.persist(item);
        //if (item.getId() == null) {
        //    em.persist(item);
        //    System.out.println(item.getName()+ item.getId()+ item.getPrice());
            System.out.println("퍼시스턴트 아이템");
        //} else {
        //    em.merge(item);
        //}
    }

    /***
     * @param id
     * @return 아이템
     *
     *
     */
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }


}
