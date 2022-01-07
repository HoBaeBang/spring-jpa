package jpabook.jpashop.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateItemDto {
    Long id;
    String name;
    int price;
    int stockQuantity;

    public void settingDto(Long id,String name, int price, int stockQuantity) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
    }
}
