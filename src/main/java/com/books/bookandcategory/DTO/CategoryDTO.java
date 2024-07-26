package com.books.bookandcategory.DTO;

import lombok.Data;
import java.util.List;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private List<BookDTO> books;

}
