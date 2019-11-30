package com.example.thole.webdeom.repositories;

import com.example.thole.webdeom.model.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {

}
