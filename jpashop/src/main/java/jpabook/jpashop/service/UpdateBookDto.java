package jpabook.jpashop.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookDto {
    String author;
    String isbn;

    public void settingBookDto(String author, String isbn) {
        this.setAuthor(author);
        this.setIsbn(isbn);
    }
}
