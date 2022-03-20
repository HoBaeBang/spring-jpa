package jpabook.jpashop.domain.algo;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long recipe_id;

    private Material material;

}
