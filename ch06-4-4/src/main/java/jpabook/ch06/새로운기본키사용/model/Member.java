package jpabook.ch06.새로운기본키사용.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private List<Orders> memberProducts = new ArrayList<>();

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

    public List<Orders> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<Orders> memberProducts) {
        this.memberProducts = memberProducts;
    }
}
