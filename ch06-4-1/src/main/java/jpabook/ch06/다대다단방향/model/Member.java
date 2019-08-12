package jpabook.ch06.다대다단방향.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 다대다 단방향
 * 관계형 데이터베이스는 정규화 된 2개로 다대다 관계를 표현할 수 없다.
 * 그러나 객체는 테이블과 다르게 객체 2개로 다대다 관계를 만들 수 있다.
 *
 * Member (N) : Product (N)
 */
@Entity
public class Member {

    @Id @Column (name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToMany
    @JoinTable( name = "MEMBER_PRODUCT", // 연결 테이블 지정
                joinColumns = @JoinColumn(name = "MEMBER_ID"), // 회원과 매핑할 조인 컬럼 정보 지정
                inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")) // 반대 방향인 상품과 매핑할 조인 컬럼 정보 지정
    private List<Product> products = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
