package jpabook.ch06.다대다양방향;

import jpabook.ch06.다대다양방향.model.Member;
import jpabook.ch06.다대다양방향.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 단방향 매핑 예제
 */
public class JpaMain6 {

    public static void main(String[] args){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // 다대다 양방향 연관관계 저장
            save(em);

            // 역방향 객체 탐색
            findInverse(em);

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

        // 회원1을 저장할 때 연결 테이블(MEMBER_PRODUCT) 에도 값이 저장된다.
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.addProduct(productA);   // 연관관계 설정
        em.persist(member1);
    }

    private static void findInverse(EntityManager em) {
        Product product = em.find(Product.class, "productA");
        List<Member> members = product.getMembers();
        for(Member member : members) {
            System.out.println("member = " + member.getUsername());
        }
    }
}
