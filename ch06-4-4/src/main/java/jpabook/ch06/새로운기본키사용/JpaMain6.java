package jpabook.ch06.새로운기본키사용;

import jpabook.ch06.새로운기본키사용.model.Member;
import jpabook.ch06.새로운기본키사용.model.Orders;
import jpabook.ch06.새로운기본키사용.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 6.4.4 다대다:새로운 기본키 사용
 * 추천하는 기본키 생성전략은 데이터베이스에서 자동으로 생성해주는 대리키를 Long 값으로 사용하는 것이다.
 * 장점은 간편히 영구히 쓸수 있으며, 비즈니스에 의존되지 않음
 * ORM 매핑시 복합키를 만들지 않아도 되므로 간단히 매핑을 완성할 수 있다.
 */
public class JpaMain6 {

    public static void main(String[] args){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            save(em);

            find(em);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void save(EntityManager em) {

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        Product productA = new Product();
        productA.setId("productB");
        productA.setName("상품B");
        em.persist(productA);

        Orders order = new Orders();
        order.setMember(member1);
        order.setProduct(productA);
        order.setOrderAmount(2);

        em.persist(order);
    }

    private static void find(EntityManager em) {

        Long orderId = 1L;
        Orders order = em.find(Orders.class, orderId);

        Member member = order.getMember();
        Product product = order.getProduct();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + order.getOrderAmount());
    }

}
