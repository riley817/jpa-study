package jpabook.ch06.연결엔티티사용.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 일대다
 * Member(1) : MemberProduct(N)
 */
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @OneToMany (mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>(); // 역방향 (회원과 회원 상품을 양방향 관계로 만듬)

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

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }
}
