package jpabook.jpashop.controller;

import jpabook.jpashop.item.Book;
import jpabook.jpashop.item.Item;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.UpdateBookDto;
import jpabook.jpashop.service.UpdateItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm form) {

        Book book = new Book();     //이런 방식을 사용하는 것보다는 북에다가 생성자 메서드를 사용하여서 만드는 것이 좋은 방법이다.
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book item = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {

//        Book book = new Book();         //준영속성 엔티티
//        book.setId(form.getId());       //jpa가 준영속성 엔티티는 관리하지 않기 때문에 그냥 변경은 일어나지 않는다.
//        book.setName(form.getName());   //준영속 엔티티를 수정하는 2가지 방법은 변경감지(dirty checking)와 병합(merge)이있다.
//        book.setPrice(form.getPrice()); //merge보다는 변경감지를 통해서 수정하여야 한다.
//        book.setStockQuantity(form.getStockQuantity());
//        book.setAuthor(form.getAuthor());
//        book.setIsbn(form.getIsbn());
//
//        itemService.saveItem(book);
        UpdateItemDto updateItemDto = new UpdateItemDto();
        UpdateBookDto updateBookDto = new UpdateBookDto();

        updateItemDto.settingDto(form.getId(),form.getName(),form.getPrice(),form.getStockQuantity());
        updateBookDto.settingBookDto(form.getAuthor(),form.getIsbn());

        itemService.updateItem(updateItemDto,updateBookDto);

        return "redirect:/items";
    }
}
