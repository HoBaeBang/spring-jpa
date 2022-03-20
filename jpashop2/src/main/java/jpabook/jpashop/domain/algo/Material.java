package jpabook.jpashop.domain.algo;

import javax.persistence.*;

@Entity
public class Material {

    @Id
    @GeneratedValue
    @Column(name = "MATERIAL_ID")
    private Long material_id;

    @Column(name = "NAME")
    private String name;

}
