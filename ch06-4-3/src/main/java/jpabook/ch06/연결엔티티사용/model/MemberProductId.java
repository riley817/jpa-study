package jpabook.ch06.연결엔티티사용.model;

import java.io.Serializable;

/**
 * 회원상품 식별자 클래스
 * JPA 에서는 복합키를 사용하려면 별도의 식별자 클래스를 만들어야 함.
 *
 * 1. 복합키는 별도의 식별자 클래스로 만들어야 한다.
 * 2. Serializable 를 구현해야 한다.
 * 3. equals 와 hashCode 메소드를 구현해야 한다.
 * 4. 기본 생성자가 있어야 한다.
 * 5. 식별자 클래스는 public 이어야 한다.
 * 6. @IdClass 를 사용하는 방법 이외에 @EmbeddedId 를 사용하는 방법이 있다.
 */
public class MemberProductId implements Serializable {

    private String member;      // MemberProduct.member 와 연결
    private String product;     // MemberProduct.product 와 연겲

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
