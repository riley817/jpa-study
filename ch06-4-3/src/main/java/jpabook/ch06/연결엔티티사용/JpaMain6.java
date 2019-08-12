package jpabook.ch06.연결엔티티사용;

import jpabook.ch06.연결엔티티사용.model.Member;
import jpabook.ch06.연결엔티티사용.model.MemberProduct;
import jpabook.ch06.연결엔티티사용.model.MemberProductId;
import jpabook.ch06.연결엔티티사용.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 연결 엔티티를 사용하기
 * @ManyToMany 사용시 연결테이블을 자동으로 처리해주므로 도메인 모델이 단순해지고 여러가지 편리하다.
 * 그러나 이 매핑을 실무에서 사용하기에는 한계가 존재한다.
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

        // 1. 회원저장
        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품1");
        em.persist(productA);

        // 회원상품저장
        MemberProduct memberProduct = new MemberProduct();
        memberProduct.setMember(member1);
        memberProduct.setProduct(productA);
        memberProduct.setOrderAmount(2);

        em.persist(memberProduct);
    }

    private static void find(EntityManager em) {

        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        MemberProduct memberProduct = em.find(MemberProduct.class, memberProductId);

        Member member = memberProduct.getMember();
        Product product = memberProduct.getProduct();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + memberProduct.getOrderAmount());
    }

}
