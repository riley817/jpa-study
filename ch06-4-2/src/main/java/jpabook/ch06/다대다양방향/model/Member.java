package jpabook.ch06.다대다양방향.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 다대다 양방향
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

    // 양방향 연관관계는 연관관계 편의 메소드를 추가해서 관리하는 것이 편리하다.
    public void addProduct(Product product) {
        this.products.add(product);
        product.getMembers().add(this);
    }
}
