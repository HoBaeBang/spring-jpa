package jpabook.jpashop.service;

import jpabook.jpashop.item.Book;
import jpabook.jpashop.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        System.out.println("Aaa"+item.getName());
        System.out.println("Aaa"+item.getCategories());
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(UpdateItemDto itemDto,UpdateBookDto bookDto) {
        Book findItem = (Book) findOne(itemDto.id);
        findItem.chageItem(itemDto);
        findItem.changeBook(bookDto);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
