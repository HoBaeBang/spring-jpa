package jpabook.jpashop.domain;

import jpabook.jpashop.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //기본생성자를 프로텍티드로 해서 막아준다 생성자를 만들경우 생성메서드 사용
public class OrderItem {


    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itme_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;     //주문 가격
    private int count;      //주문 수량

    //==생성 메서드===//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }


    //===비즈니스 로직===//
    public void cancel() {
        getItem().addStock(count);
    }

    //==조회로직==//

    /**
     * 주문 상품 전체 가격조회
     *
     * @return
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
