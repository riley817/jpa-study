package jpabook.ch06.다대다양방향.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 다대다 양방향
 * - 역방향도 @ManyToMany 를 사용한다.
 * - 양쪽 중 원하는 곳에 mappedBy 로 연관관계의 주인을 설정한다.
 * Member (N) : Product (N)
 */
@Entity
public class Product {

    @Id
    @Column (name = "PRODUCT_ID")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Member> members = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
