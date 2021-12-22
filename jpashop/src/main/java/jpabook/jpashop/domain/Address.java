package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 데이터 베이스의 내장타입임을 알리는 어노테이션
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){}

    public Address(String city,String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
