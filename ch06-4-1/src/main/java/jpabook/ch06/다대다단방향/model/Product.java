package jpabook.ch06.다대다단방향.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 다대다 단방향
 * 관계형 데이터베이스는 정규화 된 2개로 다대다 관계를 표현할 수 없다.
 * 그러나 객체는 테이블과 다르게 객체 2개로 다대다 관계를 만들 수 있다.
 *
 * Member (N) : Product (N)
 */
@Entity
public class Product {

    @Id
    @Column (name = "PRODUCT_ID")
    private String id;

    private String name;

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
}
