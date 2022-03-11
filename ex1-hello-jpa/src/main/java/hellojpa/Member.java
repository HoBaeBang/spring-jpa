package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    private Long id;
    private String name;

    public Member() {}  //JPA는 기본 생성자가 있어야 한다.

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
